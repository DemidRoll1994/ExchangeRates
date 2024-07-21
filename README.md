# Exchange rates microservice 

Features:
###  ✅ Save exchange rates of all main currencies from [The National Bank of The Republic of Belarus](https://www.nbrb.by/engl) 


**URL:** /update?date={date}

where:

*date* – date for which exchange rates are requested. required format - **YYYY**-**MM**-**DD**(**YYYY** -year e.g. **1975** or **2024**, MM - month e.g.  **01** for january or **11** for November, and DD - number of day in month e.g. **01** or **25**). For example, for April 01, 1935: **1935-04-01** or for August 28, 2023: 2023-08-28

**Result:**

returns Json-object with next fields:

*status* - info about query result. may be **success**, **internal server error** or **bad request**

*code* - http result code. May be **200**, **500**, **400**.

**Examples:**
 
_.../update?date=2013-03-13_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of March 13, 2013 and returns ```"status": "success", "code":200```

_.../update?date=1998-11-25_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of November 25, 1998 and returns ```"status": "success", "code":200```



###  ⌛ Show currency exchange rate by ISO 4217 currency code for a specific date.

<!--**URL:** /show?date={date}&code={code}

where:

*date* – date for which exchange rates are requested. required format - **YYYY**-**MM**-**DD**(**YYYY** -year e.g. **1975** or **2024**, MM - month e.g.  **01** for january or **11** for November, and DD - number of day in month e.g. **01** or **25**). For example, for April 01, 1935: **1935-04-01** or for August 28, 2023: 2023-08-28
*code* - ISO 4217 currency code. for example - **BYN**, **RUB**, **USD**, **EUR**.

**Result:**

returns Json-object with next fields:
*status* - info about query result. may be **success**, **internal server error** or **bad request**
*code* - http result code. May be **200**, **500**, **400**.

**Examples:**
 
_.../update?date=2013-03-13_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of March 13, 2013 and returns ```"status": "success", "code":200```

_.../update?date=1998-11-25_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of November 25, 1998 and returns ```"status": "success", "code":200```

  -->

_**In progress...**_
