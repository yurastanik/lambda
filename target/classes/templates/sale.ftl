<#assign CompanyName="${document.getDocumentHeader().getCompanyName()}">

<!DOCTYPE html>
<html lang="ua">

<head>
  <meta charset="UTF-8">
  <style>
    table {
      margin-left: auto;
      margin-right: auto;
      border: 2px solid #ccc;
      /*font-family: monospace, monospace;*/
      font-family: sans-serif;
      font-size: 9pt;
      padding: 4mm;
      width: 72mm;
    }

    .vertical-indent {
      height: 5mm;
    }

    td.left {
      text-align: left;
    }

    td.right {
      text-align: right;
    }

    td.center {
      text-align: center;
    }
  </style>
</head>

<body>
  <div>
    <table>
        <#setting locale="en_US">
        <#setting number_format="0.00">
        <#include 'check-header.ftl'>
		<#if document.getProducts()?has_content>
        <#list document.getProducts() as product>
            <#if product.getAmount()?has_content>
            <tr>
                <td colspan="5">${product.getAmount()} x ${product.getPrice()}</td>
            </tr>
            </#if>
            <#if product.getNationalCode()?has_content>
            <tr>
                <td colspan="5">УКТ ЗЕД: ${product.getNationalCode()}</td>
            </tr>
            </#if>
            <#if product.getCode()?has_content>
            <tr>
                <td colspan="5">АРТ.№ ${product.getCode()}</td>
            </tr>
            </#if>
            <#if product.getExciseLabels()?has_content>
            <#list product.getExciseLabels() as excise>
                <tr>
                    <td colspan="5">Акцизна марка: ${excise.getLabel()}</td>
                </tr>
            </#list>
            </#if>
            <#if product.getName()?has_content>
            <tr>
                <td colspan="3">${product.getName()}:</td>
                <#if product.getCost()?has_content>
                    <#if product.getTaxRateLetter()?has_content>
                    <td colspan="2" style="text-align:right">${product.getCost()} ${product.getTaxRateLetter()}</td>
                    <#else>
                    <td colspan="2" style="text-align:right">${product.getCost()}}</td>
                    </#if>
                </#if>
            </tr>
            </#if>
            <#if product.getDiscountSum()?has_content>
            <tr>
                <td colspan="5">Дисконт: ${product.getDiscountSum()}</td>
            </tr>
            </#if>
            <#if product.getComment()?has_content>
            <tr>
                <td colspan="5">${product.getComment()}</td>
            </tr>
            </#if>
            <tr>
                <td colspan="5">&nbsp;</td>
            </tr>
        </#list>
        </#if>
		<#if document.getPayForms()?has_content>
        <#list document.getPayForms() as payForm>
            <#if payForm.getPaymentDetails()?has_content>
                <tr>
                    <td colspan="5" style="text-align:center">--- &nbsp;Платіжна система&nbsp; ---</td>
                </tr>
                <#if payForm.getPaymentDetails().getPaymentProvider()?has_content>
                <tr>
                    <td colspan="5">Банк: ${payForm.getPaymentDetails().getPaymentProvider()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getDeviceId()?has_content>
                <tr>
                    <td colspan="5">Термінал: ${payForm.getPaymentDetails().getDeviceId()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getPersonalAccountNumber()?has_content>
                <tr>
                    <td colspan="5">ЕПЗ: ${payForm.getPaymentDetails().getPersonalAccountNumber()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getPaymentSystemName()?has_content>
                <tr>
                    <td colspan="5">ПЛАТІЖНА СИСТЕМА: ${payForm.getPaymentDetails().getPaymentSystemName()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getAuthCode()?has_content>
                <tr>
                    <td colspan="5">КОД АВТ.: ${payForm.getPaymentDetails().getAuthCode()}</td>
                </tr>
                </#if>
                <tr>
                    <td colspan="5">КАСИР Підпис не передбачено</td>
                </tr>
                <tr>
                    <td colspan="5">ДЕРЖАТЕЛЬ ЕПЗ Підпис не передбачено</td>
                </tr>
                <#if payForm.getPaymentDetails().getTransactionId()?has_content>
                <tr>
                    <td colspan="5">RRN: ${payForm.getPaymentDetails().getTransactionId()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getFormattedTransactionDateTime()?has_content>
                <tr>
                    <td colspan="5">Час транзакції ${payForm.getPaymentDetails().getFormattedTransactionDateTime()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getReceiptNumber()?has_content>
                <tr>
                    <td colspan="5">Номер Чеку: ${payForm.getPaymentDetails().getReceiptNumber()}</td>
                </tr>
                </#if>
                <tr>
                    <td colspan="5" style="text-align:center">&nbsp;</td>
                </tr>
            </#if>
        </#list>
        <tr>
            <td colspan="5" style="text-align:center">--- &nbsp;Підсумки по формам оплати&nbsp; ---</td>
        </tr>
        <#list document.getPayForms() as payForm>
            <tr>
			    <td colspan="3">${payForm.getName()}:</td>
			    <td colspan="2" style="text-align:right">${payForm.getSum()} грн</td>
            </tr>
        </#list>
        <#if document.getTotal()?has_content>
            <#if document.getTotal().getSumWithoutRounding()?has_content>
                <tr>
                    <td colspan="5" style="text-align:center">--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--- &nbsp;--</td>
                </tr>
                <tr>
                    <td colspan="5">СУМА: ${document.getTotal().getSumWithoutRounding()} грн</td>
                </tr>
            </#if>
        </#if>
		<tr>
			<td colspan="5" style="text-align:center">&nbsp;</td>
		</tr>
        </#if>
		<#if document.getTaxRates()?has_content>
            <tr>
                <td colspan="5" style="text-align:center">---&nbsp; &nbsp;Підсумки по податках&nbsp; &nbsp;---</td>
            </tr>

            <#list document.getTaxRates() as taxRate>
                <tr>
                    <#if taxRate.getLetter()?has_content>
                        <td style="text-align:right">${taxRate.getName()} ${taxRate.getLetter()}</td>
                    <#else>
                        <td style="text-align:right">${taxRate.getName()}</td>
                    </#if>
                    <td style="text-align:right">${taxRate.getPercent()}%</td>
                    <td style="text-align:right">${taxRate.getSum()}</td>
                    <#if taxRate.getSourceSum()?has_content>
                        <td style="text-align:center">від</td>
                        <td style="text-align:right">${taxRate.getSourceSum()}</td>
                    </#if>
                </tr>
            </#list>
            <tr>
                <td colspan="5" style="text-align:center">&nbsp;</td>
            </tr>
        </#if>
        <#if document.getTotal()?has_content>
            <tr>
                <td colspan="5" style="height:5px; text-align:center; width:5px">--- &nbsp;Підсумок по чеку &nbsp;---</td>
            </tr>
            <#if document.getTotal().getDiscountSum()?has_content>
                <tr>
                    <td colspan="3">ДИСКОНТ:</td>
                    <td colspan="2" style="text-align:right">${document.getTotal().getDiscountSum()} грн</td>
                </tr>
            </#if>
            <#if document.getTotal().getRoundingSum()?has_content>
                <tr>
                    <td colspan="3">ЗАОКРУГЛЕННЯ:</td>
                    <td colspan="2" style="text-align:right">${document.getTotal().getRoundingSum()} &nbsp;грн</td>
                </tr>
            </#if>
            <#if document.getTotal().getSum()?has_content>
                <tr>
                    <td colspan="3"><strong>ДО СПЛАТИ: </strong></td>
                    <td colspan="2" style="text-align:right"><strong>${document.getTotal().getSum()} &nbsp;грн</strong></td>
                </tr>
            </#if>
            <tr>
                <td colspan="3">&nbsp;</td>
                <td colspan="2">&nbsp;</td>
            </tr>
        </#if>
    </table>
  </div>
</body>

</html>