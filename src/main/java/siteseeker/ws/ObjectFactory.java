
package siteseeker.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the siteseeker.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CachedPageResponseThumbnail_QNAME = new QName("urn:siteseeker", "thumbnail");
    private final static QName _SearchResponseBets_QNAME = new QName("urn:siteseeker", "bets");
    private final static QName _SearchResponseIndexLastModified_QNAME = new QName("urn:siteseeker", "indexLastModified");
    private final static QName _SearchResponseImageHits_QNAME = new QName("urn:siteseeker", "imageHits");
    private final static QName _SearchResponseDocTypes_QNAME = new QName("urn:siteseeker", "docTypes");
    private final static QName _SearchResponseHits_QNAME = new QName("urn:siteseeker", "hits");
    private final static QName _SearchResponseLanguages_QNAME = new QName("urn:siteseeker", "languages");
    private final static QName _SearchResponseCats_QNAME = new QName("urn:siteseeker", "cats");
    private final static QName _SearchResponseAges_QNAME = new QName("urn:siteseeker", "ages");
    private final static QName _SearchResponseMatchingCats_QNAME = new QName("urn:siteseeker", "matchingCats");
    private final static QName _SearchResponseSpells_QNAME = new QName("urn:siteseeker", "spells");
    private final static QName _GetCachedPageRequest_QNAME = new QName("urn:siteseeker", "request");
    private final static QName _DoSearchRequest6Age_QNAME = new QName("urn:siteseeker", "age");
    private final static QName _AgeDate_QNAME = new QName("urn:siteseeker", "date");
    private final static QName _DoSearchRequestCategory_QNAME = new QName("urn:siteseeker", "category");
    private final static QName _DoSearchRequestFormat_QNAME = new QName("urn:siteseeker", "format");
    private final static QName _DoSearchRequestLanguage_QNAME = new QName("urn:siteseeker", "language");
    private final static QName _DoSearchRequestStemming_QNAME = new QName("urn:siteseeker", "stemming");
    private final static QName _HitCategoryNHitsInBatch_QNAME = new QName("urn:siteseeker", "nHitsInBatch");
    private final static QName _BetType_QNAME = new QName("urn:siteseeker", "type");
    private final static QName _ParamResponseDocs_QNAME = new QName("urn:siteseeker", "docs");
    private final static QName _ParamResponseDates_QNAME = new QName("urn:siteseeker", "dates");
    private final static QName _ParamResponseLangs_QNAME = new QName("urn:siteseeker", "langs");
    private final static QName _PingResponseR_QNAME = new QName("urn:siteseeker", "r");
    private final static QName _HitMetaAttributes_QNAME = new QName("urn:siteseeker", "metaAttributes");
    private final static QName _HitSourceLinkHighlighted_QNAME = new QName("urn:siteseeker", "sourceLinkHighlighted");
    private final static QName _HitMatchesQuery_QNAME = new QName("urn:siteseeker", "matchesQuery");
    private final static QName _HitTeaserImageUrl_QNAME = new QName("urn:siteseeker", "teaserImageUrl");
    private final static QName _HitAttachments_QNAME = new QName("urn:siteseeker", "attachments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: siteseeker.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetParamRequest6 }
     * 
     */
    public GetParamRequest6 createGetParamRequest6() {
        return new GetParamRequest6();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link ArrayOfLang }
     * 
     */
    public ArrayOfLang createArrayOfLang() {
        return new ArrayOfLang();
    }

    /**
     * Create an instance of {@link GetCachedPage }
     * 
     */
    public GetCachedPage createGetCachedPage() {
        return new GetCachedPage();
    }

    /**
     * Create an instance of {@link ArrayOfHitPartition }
     * 
     */
    public ArrayOfHitPartition createArrayOfHitPartition() {
        return new ArrayOfHitPartition();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link GetParamResponse }
     * 
     */
    public GetParamResponse createGetParamResponse() {
        return new GetParamResponse();
    }

    /**
     * Create an instance of {@link GetParam }
     * 
     */
    public GetParam createGetParam() {
        return new GetParam();
    }

    /**
     * Create an instance of {@link ArrayOfSpell }
     * 
     */
    public ArrayOfSpell createArrayOfSpell() {
        return new ArrayOfSpell();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link Hit }
     * 
     */
    public Hit createHit() {
        return new Hit();
    }

    /**
     * Create an instance of {@link CachedPageResponse }
     * 
     */
    public CachedPageResponse createCachedPageResponse() {
        return new CachedPageResponse();
    }

    /**
     * Create an instance of {@link ArrayOfHit }
     * 
     */
    public ArrayOfHit createArrayOfHit() {
        return new ArrayOfHit();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link FilterArray }
     * 
     */
    public FilterArray createFilterArray() {
        return new FilterArray();
    }

    /**
     * Create an instance of {@link ShortSearchResponse }
     * 
     */
    public ShortSearchResponse createShortSearchResponse() {
        return new ShortSearchResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCategory }
     * 
     */
    public ArrayOfCategory createArrayOfCategory() {
        return new ArrayOfCategory();
    }

    /**
     * Create an instance of {@link GetCachedPageRequest }
     * 
     */
    public GetCachedPageRequest createGetCachedPageRequest() {
        return new GetCachedPageRequest();
    }

    /**
     * Create an instance of {@link GetStatsAccess }
     * 
     */
    public GetStatsAccess createGetStatsAccess() {
        return new GetStatsAccess();
    }

    /**
     * Create an instance of {@link DoShortSearch }
     * 
     */
    public DoShortSearch createDoShortSearch() {
        return new DoShortSearch();
    }

    /**
     * Create an instance of {@link ShortHit }
     * 
     */
    public ShortHit createShortHit() {
        return new ShortHit();
    }

    /**
     * Create an instance of {@link ArrayOfMetaAttr }
     * 
     */
    public ArrayOfMetaAttr createArrayOfMetaAttr() {
        return new ArrayOfMetaAttr();
    }

    /**
     * Create an instance of {@link HitCategory }
     * 
     */
    public HitCategory createHitCategory() {
        return new HitCategory();
    }

    /**
     * Create an instance of {@link Bet }
     * 
     */
    public Bet createBet() {
        return new Bet();
    }

    /**
     * Create an instance of {@link DoSearchRequest }
     * 
     */
    public DoSearchRequest createDoSearchRequest() {
        return new DoSearchRequest();
    }

    /**
     * Create an instance of {@link DoClickRequest }
     * 
     */
    public DoClickRequest createDoClickRequest() {
        return new DoClickRequest();
    }

    /**
     * Create an instance of {@link GetCachedPageRequest3 }
     * 
     */
    public GetCachedPageRequest3 createGetCachedPageRequest3() {
        return new GetCachedPageRequest3();
    }

    /**
     * Create an instance of {@link Attachments }
     * 
     */
    public Attachments createAttachments() {
        return new Attachments();
    }

    /**
     * Create an instance of {@link ArrayOfShortHit }
     * 
     */
    public ArrayOfShortHit createArrayOfShortHit() {
        return new ArrayOfShortHit();
    }

    /**
     * Create an instance of {@link HitPartition }
     * 
     */
    public HitPartition createHitPartition() {
        return new HitPartition();
    }

    /**
     * Create an instance of {@link DateInfo }
     * 
     */
    public DateInfo createDateInfo() {
        return new DateInfo();
    }

    /**
     * Create an instance of {@link SearchParameter }
     * 
     */
    public SearchParameter createSearchParameter() {
        return new SearchParameter();
    }

    /**
     * Create an instance of {@link DateRange }
     * 
     */
    public DateRange createDateRange() {
        return new DateRange();
    }

    /**
     * Create an instance of {@link DoSearchRequest6 }
     * 
     */
    public DoSearchRequest6 createDoSearchRequest6() {
        return new DoSearchRequest6();
    }

    /**
     * Create an instance of {@link StatsAccessResponse }
     * 
     */
    public StatsAccessResponse createStatsAccessResponse() {
        return new StatsAccessResponse();
    }

    /**
     * Create an instance of {@link Thumbnail }
     * 
     */
    public Thumbnail createThumbnail() {
        return new Thumbnail();
    }

    /**
     * Create an instance of {@link GetCachedPageResponse }
     * 
     */
    public GetCachedPageResponse createGetCachedPageResponse() {
        return new GetCachedPageResponse();
    }

    /**
     * Create an instance of {@link GetStatsAccessResponse }
     * 
     */
    public GetStatsAccessResponse createGetStatsAccessResponse() {
        return new GetStatsAccessResponse();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link ClickResponse }
     * 
     */
    public ClickResponse createClickResponse() {
        return new ClickResponse();
    }

    /**
     * Create an instance of {@link DoClick }
     * 
     */
    public DoClick createDoClick() {
        return new DoClick();
    }

    /**
     * Create an instance of {@link ArrayOfAge }
     * 
     */
    public ArrayOfAge createArrayOfAge() {
        return new ArrayOfAge();
    }

    /**
     * Create an instance of {@link GetCachedPageRequest5 }
     * 
     */
    public GetCachedPageRequest5 createGetCachedPageRequest5() {
        return new GetCachedPageRequest5();
    }

    /**
     * Create an instance of {@link GetParamRequest }
     * 
     */
    public GetParamRequest createGetParamRequest() {
        return new GetParamRequest();
    }

    /**
     * Create an instance of {@link ArrayOfBet }
     * 
     */
    public ArrayOfBet createArrayOfBet() {
        return new ArrayOfBet();
    }

    /**
     * Create an instance of {@link ArrayOfDocType }
     * 
     */
    public ArrayOfDocType createArrayOfDocType() {
        return new ArrayOfDocType();
    }

    /**
     * Create an instance of {@link FilterNum }
     * 
     */
    public FilterNum createFilterNum() {
        return new FilterNum();
    }

    /**
     * Create an instance of {@link DoSearchRequest3 }
     * 
     */
    public DoSearchRequest3 createDoSearchRequest3() {
        return new DoSearchRequest3();
    }

    /**
     * Create an instance of {@link DoSearchResponse }
     * 
     */
    public DoSearchResponse createDoSearchResponse() {
        return new DoSearchResponse();
    }

    /**
     * Create an instance of {@link DoSearch }
     * 
     */
    public DoSearch createDoSearch() {
        return new DoSearch();
    }

    /**
     * Create an instance of {@link DoSearchRequest5 }
     * 
     */
    public DoSearchRequest5 createDoSearchRequest5() {
        return new DoSearchRequest5();
    }

    /**
     * Create an instance of {@link MetaAttr }
     * 
     */
    public MetaAttr createMetaAttr() {
        return new MetaAttr();
    }

    /**
     * Create an instance of {@link GetStatsAccessRequest }
     * 
     */
    public GetStatsAccessRequest createGetStatsAccessRequest() {
        return new GetStatsAccessRequest();
    }

    /**
     * Create an instance of {@link DoClickResponse }
     * 
     */
    public DoClickResponse createDoClickResponse() {
        return new DoClickResponse();
    }

    /**
     * Create an instance of {@link Lang }
     * 
     */
    public Lang createLang() {
        return new Lang();
    }

    /**
     * Create an instance of {@link ArrayOfHitCategory }
     * 
     */
    public ArrayOfHitCategory createArrayOfHitCategory() {
        return new ArrayOfHitCategory();
    }

    /**
     * Create an instance of {@link Age }
     * 
     */
    public Age createAge() {
        return new Age();
    }

    /**
     * Create an instance of {@link DocType }
     * 
     */
    public DocType createDocType() {
        return new DocType();
    }

    /**
     * Create an instance of {@link FilterBool }
     * 
     */
    public FilterBool createFilterBool() {
        return new FilterBool();
    }

    /**
     * Create an instance of {@link ParamResponse }
     * 
     */
    public ParamResponse createParamResponse() {
        return new ParamResponse();
    }

    /**
     * Create an instance of {@link DoShortSearchResponse }
     * 
     */
    public DoShortSearchResponse createDoShortSearchResponse() {
        return new DoShortSearchResponse();
    }

    /**
     * Create an instance of {@link Spell }
     * 
     */
    public Spell createSpell() {
        return new Spell();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Thumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "thumbnail", scope = CachedPageResponse.class)
    public JAXBElement<Thumbnail> createCachedPageResponseThumbnail(Thumbnail value) {
        return new JAXBElement<Thumbnail>(_CachedPageResponseThumbnail_QNAME, Thumbnail.class, CachedPageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "bets", scope = SearchResponse.class)
    public JAXBElement<ArrayOfBet> createSearchResponseBets(ArrayOfBet value) {
        return new JAXBElement<ArrayOfBet>(_SearchResponseBets_QNAME, ArrayOfBet.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Time }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "indexLastModified", scope = SearchResponse.class)
    public JAXBElement<Time> createSearchResponseIndexLastModified(Time value) {
        return new JAXBElement<Time>(_SearchResponseIndexLastModified_QNAME, Time.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "imageHits", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHit> createSearchResponseImageHits(ArrayOfHit value) {
        return new JAXBElement<ArrayOfHit>(_SearchResponseImageHits_QNAME, ArrayOfHit.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "docTypes", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHitPartition> createSearchResponseDocTypes(ArrayOfHitPartition value) {
        return new JAXBElement<ArrayOfHitPartition>(_SearchResponseDocTypes_QNAME, ArrayOfHitPartition.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "hits", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHit> createSearchResponseHits(ArrayOfHit value) {
        return new JAXBElement<ArrayOfHit>(_SearchResponseHits_QNAME, ArrayOfHit.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "languages", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHitPartition> createSearchResponseLanguages(ArrayOfHitPartition value) {
        return new JAXBElement<ArrayOfHitPartition>(_SearchResponseLanguages_QNAME, ArrayOfHitPartition.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "cats", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHitCategory> createSearchResponseCats(ArrayOfHitCategory value) {
        return new JAXBElement<ArrayOfHitCategory>(_SearchResponseCats_QNAME, ArrayOfHitCategory.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHitPartition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "ages", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHitPartition> createSearchResponseAges(ArrayOfHitPartition value) {
        return new JAXBElement<ArrayOfHitPartition>(_SearchResponseAges_QNAME, ArrayOfHitPartition.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfHitCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "matchingCats", scope = SearchResponse.class)
    public JAXBElement<ArrayOfHitCategory> createSearchResponseMatchingCats(ArrayOfHitCategory value) {
        return new JAXBElement<ArrayOfHitCategory>(_SearchResponseMatchingCats_QNAME, ArrayOfHitCategory.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSpell }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "spells", scope = SearchResponse.class)
    public JAXBElement<ArrayOfSpell> createSearchResponseSpells(ArrayOfSpell value) {
        return new JAXBElement<ArrayOfSpell>(_SearchResponseSpells_QNAME, ArrayOfSpell.class, SearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCachedPageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = GetCachedPage.class)
    public JAXBElement<GetCachedPageRequest> createGetCachedPageRequest(GetCachedPageRequest value) {
        return new JAXBElement<GetCachedPageRequest>(_GetCachedPageRequest_QNAME, GetCachedPageRequest.class, GetCachedPage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "age", scope = DoSearchRequest6 .class)
    public JAXBElement<FilterNum> createDoSearchRequest6Age(FilterNum value) {
        return new JAXBElement<FilterNum>(_DoSearchRequest6Age_QNAME, FilterNum.class, DoSearchRequest6 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "bets", scope = ShortSearchResponse.class)
    public JAXBElement<ArrayOfBet> createShortSearchResponseBets(ArrayOfBet value) {
        return new JAXBElement<ArrayOfBet>(_SearchResponseBets_QNAME, ArrayOfBet.class, ShortSearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfShortHit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "hits", scope = ShortSearchResponse.class)
    public JAXBElement<ArrayOfShortHit> createShortSearchResponseHits(ArrayOfShortHit value) {
        return new JAXBElement<ArrayOfShortHit>(_SearchResponseHits_QNAME, ArrayOfShortHit.class, ShortSearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSpell }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "spells", scope = ShortSearchResponse.class)
    public JAXBElement<ArrayOfSpell> createShortSearchResponseSpells(ArrayOfSpell value) {
        return new JAXBElement<ArrayOfSpell>(_SearchResponseSpells_QNAME, ArrayOfSpell.class, ShortSearchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatsAccessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = GetStatsAccess.class)
    public JAXBElement<GetStatsAccessRequest> createGetStatsAccessRequest(GetStatsAccessRequest value) {
        return new JAXBElement<GetStatsAccessRequest>(_GetCachedPageRequest_QNAME, GetStatsAccessRequest.class, GetStatsAccess.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoClickRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = DoClick.class)
    public JAXBElement<DoClickRequest> createDoClickRequest(DoClickRequest value) {
        return new JAXBElement<DoClickRequest>(_GetCachedPageRequest_QNAME, DoClickRequest.class, DoClick.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoSearchRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = DoShortSearch.class)
    public JAXBElement<DoSearchRequest> createDoShortSearchRequest(DoSearchRequest value) {
        return new JAXBElement<DoSearchRequest>(_GetCachedPageRequest_QNAME, DoSearchRequest.class, DoShortSearch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "date", scope = Age.class)
    public JAXBElement<DateRange> createAgeDate(DateRange value) {
        return new JAXBElement<DateRange>(_AgeDate_QNAME, DateRange.class, Age.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParamRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = GetParam.class)
    public JAXBElement<GetParamRequest> createGetParamRequest(GetParamRequest value) {
        return new JAXBElement<GetParamRequest>(_GetCachedPageRequest_QNAME, GetParamRequest.class, GetParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "category", scope = DoSearchRequest.class)
    public JAXBElement<FilterArray> createDoSearchRequestCategory(FilterArray value) {
        return new JAXBElement<FilterArray>(_DoSearchRequestCategory_QNAME, FilterArray.class, DoSearchRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "date", scope = DoSearchRequest.class)
    public JAXBElement<DateRange> createDoSearchRequestDate(DateRange value) {
        return new JAXBElement<DateRange>(_AgeDate_QNAME, DateRange.class, DoSearchRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "format", scope = DoSearchRequest.class)
    public JAXBElement<FilterNum> createDoSearchRequestFormat(FilterNum value) {
        return new JAXBElement<FilterNum>(_DoSearchRequestFormat_QNAME, FilterNum.class, DoSearchRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "language", scope = DoSearchRequest.class)
    public JAXBElement<FilterNum> createDoSearchRequestLanguage(FilterNum value) {
        return new JAXBElement<FilterNum>(_DoSearchRequestLanguage_QNAME, FilterNum.class, DoSearchRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBool }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "stemming", scope = DoSearchRequest.class)
    public JAXBElement<FilterBool> createDoSearchRequestStemming(FilterBool value) {
        return new JAXBElement<FilterBool>(_DoSearchRequestStemming_QNAME, FilterBool.class, DoSearchRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "nHitsInBatch", scope = HitCategory.class)
    public JAXBElement<Integer> createHitCategoryNHitsInBatch(Integer value) {
        return new JAXBElement<Integer>(_HitCategoryNHitsInBatch_QNAME, Integer.class, HitCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "type", scope = Bet.class)
    public JAXBElement<String> createBetType(String value) {
        return new JAXBElement<String>(_BetType_QNAME, String.class, Bet.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDocType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "docs", scope = ParamResponse.class)
    public JAXBElement<ArrayOfDocType> createParamResponseDocs(ArrayOfDocType value) {
        return new JAXBElement<ArrayOfDocType>(_ParamResponseDocs_QNAME, ArrayOfDocType.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "bets", scope = ParamResponse.class)
    public JAXBElement<ArrayOfBet> createParamResponseBets(ArrayOfBet value) {
        return new JAXBElement<ArrayOfBet>(_SearchResponseBets_QNAME, ArrayOfBet.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "dates", scope = ParamResponse.class)
    public JAXBElement<DateInfo> createParamResponseDates(DateInfo value) {
        return new JAXBElement<DateInfo>(_ParamResponseDates_QNAME, DateInfo.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "cats", scope = ParamResponse.class)
    public JAXBElement<ArrayOfCategory> createParamResponseCats(ArrayOfCategory value) {
        return new JAXBElement<ArrayOfCategory>(_SearchResponseCats_QNAME, ArrayOfCategory.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "ages", scope = ParamResponse.class)
    public JAXBElement<ArrayOfAge> createParamResponseAges(ArrayOfAge value) {
        return new JAXBElement<ArrayOfAge>(_SearchResponseAges_QNAME, ArrayOfAge.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLang }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "langs", scope = ParamResponse.class)
    public JAXBElement<ArrayOfLang> createParamResponseLangs(ArrayOfLang value) {
        return new JAXBElement<ArrayOfLang>(_ParamResponseLangs_QNAME, ArrayOfLang.class, ParamResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "r", scope = PingResponse.class)
    public JAXBElement<Boolean> createPingResponseR(Boolean value) {
        return new JAXBElement<Boolean>(_PingResponseR_QNAME, Boolean.class, PingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoSearchRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "request", scope = DoSearch.class)
    public JAXBElement<DoSearchRequest> createDoSearchRequest(DoSearchRequest value) {
        return new JAXBElement<DoSearchRequest>(_GetCachedPageRequest_QNAME, DoSearchRequest.class, DoSearch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMetaAttr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "metaAttributes", scope = Hit.class)
    public JAXBElement<ArrayOfMetaAttr> createHitMetaAttributes(ArrayOfMetaAttr value) {
        return new JAXBElement<ArrayOfMetaAttr>(_HitMetaAttributes_QNAME, ArrayOfMetaAttr.class, Hit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "sourceLinkHighlighted", scope = Hit.class)
    public JAXBElement<String> createHitSourceLinkHighlighted(String value) {
        return new JAXBElement<String>(_HitSourceLinkHighlighted_QNAME, String.class, Hit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "matchesQuery", scope = Hit.class)
    public JAXBElement<Boolean> createHitMatchesQuery(Boolean value) {
        return new JAXBElement<Boolean>(_HitMatchesQuery_QNAME, Boolean.class, Hit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "teaserImageUrl", scope = Hit.class)
    public JAXBElement<String> createHitTeaserImageUrl(String value) {
        return new JAXBElement<String>(_HitTeaserImageUrl_QNAME, String.class, Hit.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Attachments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:siteseeker", name = "attachments", scope = Hit.class)
    public JAXBElement<Attachments> createHitAttachments(Attachments value) {
        return new JAXBElement<Attachments>(_HitAttachments_QNAME, Attachments.class, Hit.class, value);
    }

}
