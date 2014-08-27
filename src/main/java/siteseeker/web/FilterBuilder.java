package siteseeker.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.LogFactory;

import siteseeker.ws.SearchResponse;
import siteseeker.ws.HitPartition;
import siteseeker.ws.HitCategory;
import siteseeker.ws.Spell;
import siteseeker.search.*;

public class FilterBuilder {
  private SearchIndexInfo indexInfo;
  private SearchResponse response;
  private final SearchUrl url;

  public FilterBuilder(SearchIndexInfo info, SearchResponse response, SearchUrl url) {
    this.indexInfo = info;
    this.response = response;
    this.url = url;
  }
  public List<SearchFilter> buildLanguages() {
    if (response == null || response.getLanguages() == null) {
      return indexInfo.getLanguages();
    }
    List<SearchFilter> filters = new ArrayList<SearchFilter>();
    final int selectedId  = url.getLanguage();
    
    // Add meta filter "any"
    SearchFilter anyLanguage = indexInfo.getLanguages().get(0);
    anyLanguage.setIsSelected(anyLanguage.getId() == selectedId); 
    anyLanguage.setClickUrl(url.buildLanguageUrl(anyLanguage.getId()));
    filters.add(anyLanguage);

    List<HitPartition> partition = response.getLanguages().getValue().getHitPartition();
    int nHitsAnyLanguage = 0; // Sum n hits for languages
    for (HitPartition i : partition) {
      SearchFilter sf = indexInfo.getLanguageFilter(i.getId());
      if (sf != null) {
        SearchFilter filter = new SearchFilter(sf);
        filter.setNHits(i.getNHits());
        filter.setIsSelected(selectedId == filter.getId());
        filter.setClickUrl(url.buildLanguageUrl(filter.getId()));
        filters.add(filter);
	nHitsAnyLanguage += filter.getNHits();
      }
    }
    // Set nHits for "any" filter
    anyLanguage.setNHits(nHitsAnyLanguage);
    return filters;
  }

  public List<SearchFilter> buildFileFormats() {
    if (response == null || response.getDocTypes() == null) {
      return indexInfo.getFileFormats();
    }
    List<SearchFilter> filters = new ArrayList<SearchFilter>();
    final int selectedId  = url.getFileFormat();
    final int allFileFormatsId = 0; 
    List<HitPartition> partition = response.getDocTypes().getValue().getHitPartition();
    for (HitPartition i : partition) {
      SearchFilter sf = indexInfo.getFileFormatFilter(i.getId());
      if (sf != null) {
        SearchFilter filter = new SearchFilter(sf); //, sf.getId() == allFileFormatsId);
        filter.setNHits(i.getNHits());
        filter.setIsSelected(selectedId == filter.getId());
        filter.setClickUrl(url.buildFileFormatUrl(filter.getId()));
        filters.add(filter);
      }
    }
    return filters;
  }

  public List<SearchFilter> buildAges() {
    if (response == null || response.getAges() == null) {
      return indexInfo.getAges();
    }
    List<SearchFilter> filters = new ArrayList<SearchFilter>();
    List<HitPartition> partition = response.getAges().getValue().getHitPartition();
    final int selectedId  = url.getAge();
    for (HitPartition i : partition) {
      SearchFilter sf = indexInfo.getAgeFilter(i.getId());
      if (sf != null) {
        SearchFilter filter = new SearchFilter(sf);
        filter.setNHits(i.getNHits());
        filter.setIsSelected(selectedId == filter.getId());
        filter.setClickUrl(url.buildAgeUrl(filter.getId()));
        filters.add(filter);
      }
    }
    return filters;
  }

  /**
   * Returns a list of category groups with information about the
   * number of hits in every category.
   *
   * @return The category groups
   */
  public List<CategoryGroup> buildCategoryGroups() {
    if (response == null || response.getCats() == null) {
      return indexInfo.getCategoryGroups();
    }

    LogFactory.getLog(getClass()).debug("buildCategoryGroups: " + response.getCats());

    // Insert non-empty categories into their groups. The map named groupsById
    // maps an group id to a group.
    Map<Integer, CategoryGroup> groupsById = new TreeMap<Integer, CategoryGroup>();
    {
      List<HitCategory> hitCategories = response.getCats().getValue().getHitCategory();
      final Set<Integer> selectedIds  = url.getCategorySet();
      for (HitCategory i : hitCategories) {
        CategoryGroup group = groupsById.get(i.getGroupId()); 
        if (group == null) {
          CategoryGroup cachedGroup = indexInfo.getCategoryGroup(i.getGroupId());
          group = new CategoryGroup(cachedGroup.getName(), cachedGroup.getId());
          groupsById.put(group.getId(), group);
        }
        SearchFilter sf = indexInfo.getCategoryFilter(i.getId());
        if (sf != null) {
          SearchFilter filter = new SearchFilter(sf);
          filter.setNHits(i.getNHits());
          filter.setIsSelected(selectedIds.contains(filter.getId()));
          filter.setClickUrl(url.buildCategoryUrl(filter.getId()));
          group.addCategory(filter);
        }
      }
    }

    // Insert groups in same order as they are ordered in SearchIndexInfo
    List<CategoryGroup> groups = new ArrayList<CategoryGroup>();
    for (CategoryGroup i : indexInfo.getCategoryGroups()) {
      CategoryGroup g = groupsById.get(i.getId());
      if (g != null) {
        groups.add(g);
      }
    }
    LogFactory.getLog(getClass()).debug("END buildCategoryGroups: " + groups.size());
    return groups;
  }

  /*
    1 relevance
    2 modification date
    3 category
    4 title
    5 category, but with nHits hits per category and batch instead of nHits hits per batch
  */
  public Map<String, SortOrder> buildSortOrders() {
    Map<String, SortOrder> sortOrders = new TreeMap<String, SortOrder>();
    sortOrders.put("relevance", new SortOrder("relevance", 1, (url.getSortOrder() == 1), url.buildSortOrderUrl(1)));
    sortOrders.put("date", new SortOrder("date", 2, (url.getSortOrder() == 2), url.buildSortOrderUrl(2)));
    sortOrders.put("category", new SortOrder("category", 3, (url.getSortOrder() == 3), url.buildSortOrderUrl(3)));
    sortOrders.put("title", new SortOrder("title", 4, (url.getSortOrder() == 4), url.buildSortOrderUrl(4)));
    sortOrders.put("random", new SortOrder("random", 9, (url.getSortOrder() == 9), url.buildSortOrderUrl(9)));
    return sortOrders;
  }

  public List<SpellingSuggestion> buildSpellingSuggestions() {
    if (response == null || response.getSpells() == null)
      return null;
    List<SpellingSuggestion> suggestions = new ArrayList<SpellingSuggestion>();
    List<Spell> wsSuggestions = response.getSpells().getValue().getSpell();
    for (Spell s : wsSuggestions) {
      suggestions.add(new SpellingSuggestion(s.getHtmlspell(), 
                                             s.getSpell(), 
                                             url.buildSpellingUrl(s.getSpell())));
    }
    return suggestions;
  }

  public PageLinkList buildPageLinks() {
    int pageNumber = 0;
    int nPages = 0;
    if (response != null) {
      pageNumber = response.getBatchNumber();
      nPages = response.getNBatch();
    }
    PageLinkList pageLinks = 
      new PageLinkList(url, pageNumber, nPages, 10);
    pageLinks.createPageLinks();
    return pageLinks;
  }

  private List<Hit> _buildHitsHelper(String portletIdentifier, String language, String queryExtension, List<siteseeker.ws.Hit> wsHits) {
    List<Hit> hits = new ArrayList<Hit>();
    if (wsHits == null) {
      return hits;
    }
    for (siteseeker.ws.Hit wsHit : wsHits) {
      Hit hit = new Hit(wsHit);
      hits.add(hit);
      hit.setCacheUrl(url.buildCacheUrl(portletIdentifier, language, hit.getUrl(), hit.getNumber(), queryExtension));
      hit.setFileFormat(indexInfo.getFileFormatFilter(wsHit.getDoctypeId()));
      List<Hit> attachments;
      if (wsHit.getAttachments() == null || wsHit.getAttachments().getValue() == null) {
        attachments = new ArrayList<Hit>();
      }
      else {
        // We do only traverse the ws tree, so there shouldn't be any risk for eternal recursion.
        attachments = _buildHitsHelper(portletIdentifier, language, queryExtension, wsHit.getAttachments().getValue().getAttachments());
      }
      hit.setAttachments(attachments);
      List<SearchFilter> categories = new ArrayList<SearchFilter>();
      for (int catid : hit.getCategoryIds()) {
	  SearchFilter sf = indexInfo.getCategoryFilter(catid);
	  if (sf != null) {
	      categories.add(sf);
	  }
      }
      hit.setCategories(categories);
    }
    return hits;
  }

  public List<Hit> buildHits(final String portletIdentifier, final String language, final String queryExtension) {
    if (response == null || response.getHits() == null)
      return new ArrayList<Hit>();
    return _buildHitsHelper(portletIdentifier, language, queryExtension, response.getHits().getValue().getHit());
  }

  public List<BestBet> buildBestBets() {
    List<BestBet> bestBets = new ArrayList<BestBet>();
    if (response == null || response.getBets() == null) {
      return bestBets;
    }
    for (siteseeker.ws.Bet wsBet : response.getBets().getValue().getBet()) {
      BestBet bestBet = new BestBet(wsBet);
      bestBets.add(bestBet);
      bestBet.setLanguage(indexInfo.getLanguageFilter(bestBet.getLanguageId()));
    }
    return bestBets;
  }
}

