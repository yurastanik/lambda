        <!-- PRODUCT BEGIN -->
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
                <td colspan="2" style="text-align:right">${product.getCost()} ${product.getTaxRateLetter()}</td>
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
            <#if product.getExciseLabels()?has_content>
            <tr>
                <td colspan="5">&nbsp;</td>
            </tr>
            </#if>
        </#list>
		</#if>
		<!-- PRODUCT END -->