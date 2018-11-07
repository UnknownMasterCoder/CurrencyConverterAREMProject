#Proyecto CurrencyConverter
##AREM - Arquitectura Empresarial
###Presentado por: Pedro Mayorga

##About Us

Esta aplicacion web es un **Convertidor de Moneda global**, con la mayoria de divisas disponibles en el mundo. Recibe una cantidad de dinero en cierto tipo de divisa y muestra el valor de dicha cantidad de dinero en cualquier divisa deseada.

##Model
Modelación del proyecto
###Requerimientos del Proyecto
![alt text](https://raw.githubusercontent.com/unknownmastercoder/CurrencyConverterAREMProject/master/diagrams/Requerimientos.png)
###Diagrama de Clases
![alt text](https://raw.githubusercontent.com/unknownmastercoder/CurrencyConverterAREMProject/master/diagrams/Diagrama Clases Currency Converter.png)
###Arquitectura del Proyecto
![alt text](https://raw.githubusercontent.com/unknownmastercoder/CurrencyConverterAREMProject/master/diagrams/Diagrama Arquitectura CurrencyConverter2.png)

##Run
This WebApp runs through the localhost port:
```
8080
```
With the main page on the resource:
```
index
```
In the location:
[localhost:8080/index](localhost:8080/index)

##How To Use
1. Ingrese la cantidad de dinero que desea convertir.
2. Seleccione el tipo de moneda de la cantidad que acabó de ingresar.
3. Seleccione el tipo de moneda deseado para realizar la conversión.
4. Haga clic en **__"Convert"__**

##Restrictions
-Las monedas con cantidades en números decimales, se manejan con "." en vez de ","
-La cuenta gratuita de Currency Layer solamente deja convertir desde $USD a cualquier otra moneda, por lo que conversiones desde otras monedas se encuentran bloqueadas.
