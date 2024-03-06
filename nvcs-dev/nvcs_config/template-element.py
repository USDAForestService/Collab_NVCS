def element_<%internalid%>():

    """<%name%>"""
    """<%id%>"""
    level = '<%level%>'
    code = '<%id%>'

    <%description%>
    
    <%filters%>

    def match(plot):
        logging.debug('%s|NODE=<%internalid%>|<%name%>', plot.ident)
        result = (<%trigger%>)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match
