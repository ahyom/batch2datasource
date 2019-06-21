/*Create mysql table script*/
create table products
(
  ID_PRODUCT         int auto_increment
    primary key,
  NAME_PRODUCT       varchar(255) null,
  COST_PRICE_PRODUCT double       null,
  SALE_PRICE_PRODUCT double       null,
  BARCODE_PRODUCT    varchar(50)  null
);
--
/*Create postgre table script*/
create table products
(
  id_product         serial not null
    constraint products_pk
      primary key,
  name_product       varchar(255),
  cost_price_product double precision,
  sale_price_product double precision,
  barcode_product    varchar(50)
);
--
/*Insert rows to test application*/
INSERT INTO `PRODUCT` (`NAME_PRODUCT`,`COST_PRICE_PRODUCT`,`SALE_PRICE_PRODUCT`,`BARCODE_PRODUCT`) VALUES ("noodles","3.47","1.95","444184445"),("desserts","4.72","6.60","835752816"),("sandwiches","7.98","5.91","030252273"),("stews","3.12","0.71","486636297"),("soups","9.91","4.92","104717587"),("soups","7.15","0.64","884697497"),("salads","0.13","4.54","987539706"),("pies","4.76","2.84","607755154"),("soups","1.47","4.26","118402640"),("stews","9.87","5.26","522967739"),("desserts","6.36","2.99","629953578"),("seafood","3.22","9.94","646536471"),("soups","5.17","2.46","040398084"),("sandwiches","7.92","2.18","544515547"),("cereals","5.84","2.20","859911469"),("stews","4.44","9.09","444192055"),("soups","1.75","6.96","488140138"),("stews","3.02","3.29","599645533"),("pasta","3.16","5.03","875340604"),("pies","1.31","0.34","066351202"),("sandwiches","2.54","1.82","305141239"),("soups","6.77","0.79","233710765"),("sandwiches","3.49","7.27","794529292"),("sandwiches","0.91","6.08","836631925"),("seafood","5.80","4.91","238063081"),("seafood","1.71","0.64","802139475"),("seafood","1.69","7.41","508324402"),("desserts","6.77","6.68","041108076"),("noodles","0.37","4.98","277863252"),("cereals","4.83","5.27","046068949"),("seafood","5.00","7.88","896507204"),("pasta","2.48","4.28","438005569"),("cereals","6.15","1.51","883140485"),("cereals","3.13","9.62","532737302"),("seafood","1.67","9.34","336268641"),("pasta","4.81","1.47","290061340"),("pasta","8.01","1.66","361536222"),("cereals","5.70","1.78","636574009"),("noodles","4.54","5.44","884724598"),("sandwiches","8.94","1.37","672965411"),("desserts","1.06","4.96","915818263"),("desserts","9.37","5.46","025738104"),("pasta","9.36","1.95","568978520"),("seafood","8.74","0.96","106970917"),("soups","5.02","6.93","806114366"),("noodles","7.43","8.35","518972446"),("seafood","7.78","2.85","279948760"),("salads","9.99","7.60","078155293"),("soups","1.95","1.29","559972267"),("salads","8.44","5.59","794900144"),("seafood","0.11","5.57","226483779"),("stews","7.75","2.73","919135619"),("salads","5.93","0.99","507722651"),("salads","7.11","4.99","061239364"),("soups","1.78","7.00","453192496"),("seafood","8.11","4.17","270238457"),("noodles","2.09","3.72","945431075"),("cereals","9.34","9.51","178478026"),("cereals","3.10","2.94","532571845"),("pies","4.76","0.18","381680526"),("desserts","4.45","5.32","028400564"),("soups","5.69","6.88","966985321"),("soups","0.31","8.25","096949378"),("sandwiches","3.56","6.72","550456578"),("desserts","9.27","1.25","160484014"),("noodles","9.00","3.54","048415340"),("sandwiches","0.79","0.36","084548594"),("seafood","6.39","3.11","305625998"),("salads","9.71","1.00","611169782"),("salads","6.94","3.33","423767971"),("pies","4.88","3.89","734317525"),("desserts","1.76","4.07","591562758"),("cereals","0.35","5.97","564905228"),("pasta","1.80","8.01","342204063"),("sandwiches","7.22","7.16","874559757"),("stews","7.76","0.33","794786572"),("seafood","5.53","9.12","948649147"),("noodles","1.58","6.76","034291759"),("stews","7.00","4.50","983511253"),("stews","8.97","3.99","628839474"),("soups","1.95","1.66","575351847"),("cereals","1.95","3.63","923743016"),("noodles","7.25","6.26","399985261"),("sandwiches","1.52","8.66","394973078"),("sandwiches","4.10","4.92","088809625"),("pies","5.90","7.98","370891294"),("desserts","8.97","1.58","687161498"),("soups","4.87","8.94","082260081"),("stews","9.95","0.87","931045838"),("seafood","8.95","9.76","876841399"),("desserts","8.27","5.78","785684706"),("sandwiches","9.02","4.83","103922951"),("stews","6.25","2.19","689183628"),("noodles","9.69","5.75","043360709"),("sandwiches","1.68","9.80","786875676"),("pies","3.66","0.80","404622372"),("pasta","0.80","9.93","485069439"),("seafood","6.33","1.46","357239542"),("noodles","9.45","9.15","686473767"),("sandwiches","3.96","9.90","574106014");