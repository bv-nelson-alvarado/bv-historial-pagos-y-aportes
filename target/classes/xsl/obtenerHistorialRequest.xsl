<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="rutdv"></xsl:param>
	<xsl:param name="poliza"></xsl:param>
	<xsl:param name="fechaDesde"></xsl:param>
	<xsl:param name="fechaHasta"></xsl:param>
	<xsl:template match="/">
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
			xmlns:ser="http://service.ws.bicevida.cl/">
			<soapenv:Header />
			<soapenv:Body>
				<ser:getPagosYAportes>
					<!--Optional: -->
					<rutDv>
						<xsl:value-of select="$rutdv"></xsl:value-of>
					</rutDv>
					<!--Optional: -->
					<poliza>
						<xsl:value-of select="$poliza"></xsl:value-of>
					</poliza>
					<!--Optional: -->
					<fechaDesde>
						<xsl:value-of select="$fechaDesde"></xsl:value-of>
					</fechaDesde>
					<!--Optional: -->
					<fechaHasta>
						<xsl:value-of select="$fechaHasta"></xsl:value-of>
					</fechaHasta>
				</ser:getPagosYAportes>

			</soapenv:Body>
		</soapenv:Envelope>

	</xsl:template>
</xsl:stylesheet>	