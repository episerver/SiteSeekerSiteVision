# Add your language file here:
TARGETS = api.html #api.pdf

XSLTPROC = /usr/bin/xsltproc
XSL = api.xsl
PDFGEN = /usr/bin/dblatex

%.html: %.xml $(XSL)
	@$(XSLTPROC) -o $@ $(XSL) $<

%.pdf: %.xml
	@$(PDFGEN) $<

all: $(TARGETS)

clean:
	@rm -f *.html *.pdf
