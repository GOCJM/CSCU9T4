<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Menu</h2>
                <xsl:for-each select="RESTAURANT/section">
                    <table border="1">
                        <tr bgcolor="green">
                            <th colspan="2">
                                <xsl:value-of select="title"/>
                            </th>
                        </tr>
                        <xsl:for-each select="items/item">
                            <xsl:sort select="price" data-type="number" order="ascending"/>
                                <tr>
                                    <td>
                                        <xsl:value-of select="name"/>
                                    </td>
                                    <xsl:choose>
                                        <xsl:when test="price >= 10">
                                            <td bgcolor="red">
                                                <xsl:value-of select="price"/>
                                            </td>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <td>
                                                <xsl:value-of select="price"/>
                                            </td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                    <td>
                                        <xsl:value-of select="description"/>
                                    </td>
                                </tr>
                        </xsl:for-each>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>