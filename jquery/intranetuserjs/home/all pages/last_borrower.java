/* This keeps the lastborrower feature from storing patron data in cookies on the local machine */
/* The Koha community added a "Last borrower" feature that stores the account information for the last patron to check materials out in a cookie that's stored on the local machine.  Whether or not this data can be seen is governed by a system preference that we have turned off.  Even when it's turned off, though, the patron data is still stored in a cookie on the local machine, creating a potential privacy issue.  This code prevents the data from being stored at all. Bug 24549 should eliminate the need for this code.*/

//BEGIN addresses lastborrower security concern
 $.cookie("lastborrowercard", null, { path: '/' });
 $.cookie("lastborrowername", null, { path: '/' });
 $.cookie("lastborrowernumber", null, { path: '/' });
