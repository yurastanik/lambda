package document.common

import java.lang.IllegalArgumentException

enum class InternalDocumentType(val value: String) {

    /**
     * Чек реалізації товарів/послуг
     */
    SALE("0"),

    /**
     * Чек переказу коштів
     */
    FUNDS_TRANSFER("1"),

    /**
     * Чек операції обміну валюти
     */
    CURRENCY_EXCHANGE("2"),

    /**
     * Чек видачі готівки
     */
    CASH_WITHDRAWAL("3"),

    /**
     * Чек застави в ломбарді
     */
    PAWN("4"),

    /**
     * Відкриття зміни
     */
    OPEN_SHIFT("100"),

    /**
     * Закриття зміни
     */
    CLOSE_SHIFT("101"),

    /**
     * Початок офлайн сесії
     */
    BEGIN_OFFLINE_SESSION("102"),

    /**
     * Завершення офлайн сесії
     */
    FINISH_OFFLINE_SESSION("103");

    companion object{

        fun byInternalValue(value: String): InternalDocumentType
        {
            values().forEach {
                if(it.value == value) return it
            }

            throw IllegalArgumentException("Does not found enum with such internal value: $value")
        }
    }

}
