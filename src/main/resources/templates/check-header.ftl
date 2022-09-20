
<!-- HEADER BEGIN -->
<tr>
    <td colspan="5" style="text-align:center">ФОП &ldquo;${document.getDocumentHeader().getCompanyName()}&rdquo;</td>
</tr>
<tr>
    <td colspan="5" style="text-align:center">${document.getDocumentHeader().getPointName()}</td>
</tr>
<#if document.getDocumentHeader().getPointAddress()?has_content>
<tr>
    <td colspan="5" style="text-align:center">${document.getDocumentHeader().getPointAddress()}</td>
</tr>
</#if>
<#if document.getDocumentHeader().getVatNumber()?has_content>
<tr>
    <td colspan="5" style="text-align:center">ПН ${document.getDocumentHeader().getVatNumber()}</td>
</tr>
</#if>
<#if document.getDocumentHeader().getSellerId()?has_content>
<tr>
    <td colspan="5" style="text-align:center">ІД ${document.getDocumentHeader().getSellerId()}</td>
</tr>
</#if>
<tr>
    <td colspan="5" style="text-align:center">--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--</td>
</tr>

<!-- HEADER END -->