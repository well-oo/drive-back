INSERT INTO CATEGORY VALUES(1,'alimentaire',1);
INSERT INTO CATEGORY VALUES(2,'hygiène',2);
INSERT INTO CATEGORY VALUES(3,'automobile',3);
INSERT INTO CATEGORY VALUES(4,'première nécessité',4);
INSERT INTO CATEGORY VALUES(5,'high-tech',5);

INSERT INTO CUSTOMER VALUES('test','test@gmail.com','John','Doe','test',null);
INSERT INTO CUSTOMER VALUES('chris','chris@gmail.com','Christopher','Ducrocq','chris',null);

INSERT INTO ARTICLE VALUES('Perishable',1,'1501234567890','https://images-na.ssl-images-amazon.com/images/I/81AaNEF0AdL._SL1500_.jpg','Barilla Pâtes Farfalle 1 kg',125,20,0.05,'2021-04-12','lot');
INSERT INTO ARTICLE VALUES('Perishable',2,'3501237561890','https://www.toutpratique.com/img/cms/salade-verte-laitue-scarole-pesticide-comment-laver-la-salade-salade-en-sachet-danger.png','Salade verte',150,5,0.20,'2019-06-28','lot');
INSERT INTO ARTICLE VALUES('Product',3,'4501237561666','https://images-na.ssl-images-amazon.com/images/I/71a9X9fiF2L._SL1318_.jpg','Savon Naturel',299,100,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',4,'8645237561666','https://az25411.vo.msecnd.net/oscjpg/zoom/21/717419-02.jpg','Balai d’essuie-glace',2999,25,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',5,'9907423139764','https://images-na.ssl-images-amazon.com/images/I/61NV4k1oDSL._SL1000_.jpg','Poste radio voiture',1999,10,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',6,'9907343133264','https://gloimg.gbtcdn.com/soa/gb/pdm-product-pic/Electronic/2018/09/15/source-img/20180915110454_83213.jpg','Smartphone 4G Xiaomi Mi 8 Version Globale - Noir',49999,40,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',7,'5557343133264','https://images-na.ssl-images-amazon.com/images/I/61cdQZopyeL._SL1000_.jpg','Scorpio - Gel Douche Homme - Rouge - Flacon 250 ml - Lot de 2',386,100,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',8,'7864353133264','https://images-na.ssl-images-amazon.com/images/I/51HcaYHfMzL._SL1038_.jpg','Scorpio - Eau de Toilette - Homme - Rouge - 75 ml',899,25,0.20,null,null);
INSERT INTO ARTICLE VALUES('Perishable',9,'7867830933264','https://media.auchan.fr/MEDIASTEP68465602_460x460/ADR/Herta-knacki-x6-210g-P298336-1','Herta knacki x6 -210g',249,100,0.05,'2019-07-12','lot');
INSERT INTO ARTICLE VALUES('Perishable',10,'7867830764589','https://media.auchan.fr/MEDIASTEP57468652_460x460/ADR/Auchan-riz-thai-bio-500g-P417377-1','Auchan riz thaï bio 500g',199,200,0.05,'2021-07-12','lot');
INSERT INTO ARTICLE VALUES('Product',11,'1346783459637','https://dyw7ncnq1en5l.cloudfront.net/optim/produits/0/42431/xps-13-2018_e2a535a9b4e666db__450_400.png','Dell XPS 13 9360',89999,25,0.20,null,null);
INSERT INTO ARTICLE VALUES('Product',12,'3475890983412','https://images-na.ssl-images-amazon.com/images/I/51WqYDg2pSL._SL1024_.jpg','Apple iMac',139999,5,0.20,null,null);

INSERT INTO ARTICLE_CATEGORIES VALUES(1,1);
INSERT INTO ARTICLE_CATEGORIES VALUES(2,1);
INSERT INTO ARTICLE_CATEGORIES VALUES(3,2);
INSERT INTO ARTICLE_CATEGORIES VALUES(4,3);
INSERT INTO ARTICLE_CATEGORIES VALUES(1,4);
INSERT INTO ARTICLE_CATEGORIES VALUES(3,4);
INSERT INTO ARTICLE_CATEGORIES VALUES(5,3);
INSERT INTO ARTICLE_CATEGORIES VALUES(5,5);
INSERT INTO ARTICLE_CATEGORIES VALUES(6,5);
INSERT INTO ARTICLE_CATEGORIES VALUES(7,2);
INSERT INTO ARTICLE_CATEGORIES VALUES(8,2);
INSERT INTO ARTICLE_CATEGORIES VALUES(9,1);
INSERT INTO ARTICLE_CATEGORIES VALUES(9,4);
INSERT INTO ARTICLE_CATEGORIES VALUES(10,4);
INSERT INTO ARTICLE_CATEGORIES VALUES(10,1);
INSERT INTO ARTICLE_CATEGORIES VALUES(11,5);
INSERT INTO ARTICLE_CATEGORIES VALUES(12,5);