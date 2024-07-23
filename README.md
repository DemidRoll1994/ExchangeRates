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
 
_.../update?date=2013-03-13_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of March 13, 2013, and returns ```"status": "success", "code":200```

_.../update?date=1998-11-25_ - updates data about exchange rates of The National Bank of The Republic of Belarus as of November 25, 1998 and returns ```"status": "success", "code":200```



###  ✅ Show currency exchange rate by ISO 4217 currency code for a specific date.

**URL:** /show?date={date}&code={code}

where:

*date* – date for which exchange rates are requested. required format - **YYYY**-**MM**-**DD**(**YYYY** -year e.g. **1975** or **2024**, MM - month e.g.  **01** for january or **11** for November, and DD - number of day in month e.g. **01** or **25**). For example, for April 01, 1935: **1935-04-01** or for August 28, 2023: 2023-08-28
*code* - ISO 4217 currency code. for example - **BYN**, **RUB**, **USD**, **EUR**.

**Result:**

returns Json-object with next fields:

*status* - info about query result. contains may be **Exchange rate is <some 
value> <currency code> = <some value> BYN"**, **internal server error** 
or **bad request**

*code* - http result code. May be **200**, **500**, **400**.

**Examples:**
 
_.../show?date=2010-10-07&currency_code=RUB_ - show data about Russian ruble 
exchange rates of The National Bank of The Republic of Belarus as of 
October 07, 2010 and returns```"status": "Exchange rate is 100,000000 RUB = 3,
400400 BYN","code": 200``` if data about rates at this date is exist or 
```"status": "No info about that date and currency code", "code": 404``` if 
there is no data about exchange rate at this date.

_.../show?date=2015-10-07&currency_code=USD_ - show data about United States 
Dollar exchange rates of The National Bank of The Republic of Belarus as of
October 07, 2015 and returns ```"status": "Exchange rate is 1,000000 USD =
17629,000000 BYN", "code": 200``` if data about rates at this date is exist or 
```"status": "No info about that date and currency code", "code": 404``` if 
there is no data about exchange rate at this date.


