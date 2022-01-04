/* First sort by country in descending order and then city in descending order. */
SELECT * FROM Customers ORDER BY country DESC, city DESC;

/* Get the records of the customer with maximum customer id. */
SELECT * FROM Customers WHERE `CustomerId` = (SELECT max(CustomerId) FROM Customers);

/* Get the records of the customer with 5th maximum customer id. */
SELECT * FROM  (SELECT * FROM Customers order by CustomerID DESC LIMIT 5) T ORDER BY T.CustomerID LIMIT 1;      

/* Get the records of the customer with 6th maximum customer id.
   For Nth maximum, we have to write DESC LIMIT (N-1),1 */
SELECT * FROM Customers ORDER BY `CustomerId` DESC limit 5,1;