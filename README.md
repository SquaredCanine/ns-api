NS API
======
I altered this code, the source is [GITHUB](https://github.com/pvanassen/ns-api). I simply updated the code so it can be used with the newest NS prijzen API (v3).
An API for talking to the NS (Dutch railways) [API](http://www.ns.nl/api/api) interface written in Java. 
The NS is using a mix between Dutch and English terms in their API. This 
reflects back to the Java implementation. The preferred language is English 
but some Dutch terms show up. Javadoc is English. When Dutch terms are used 
a translation is provided


Usage
=====
To use the NS api you need to register an account with the NS. You can apply for an account at [NS API](http://www.ns.nl/api/api). 

You will receive a username and password. To use the Java api, you initialize the NsApi object: 

```Java
NsApi nsApi = new NsApi(username, password);
```
Next step is to create a request, eg a 'actuele vertrektijden' request to get the current departures: 

```Java
ApiRequest<ActueleVertrekTijden> request = RequestBuilder.getActueleVertrektijden(stationName)
```

To do the actual request, you call getApiResponse with your request: 

```Java
ActueleVertrekTijden vertrekTijden = nsApi.getApiResponse(request); 
```

A new immutable object ActueleVertrekTijden is created containing the result of the API call. 

All classes are immutable and thread safe.


Code borrowing
==============
The biggest part of this code is written by Paul van Assen (you can find him on github here: [GITHUB](https://github.com/pvanassen) )
I changed the prijzen part of this code, because they updated the API. I tried to follow the same structure as pvanassen did.
For parsing the XML I made use of the code found in this article: http://blog.another-d-mention.ro/programming/the-simplest-way-to-parse-xml-in-java/

License
=======
The code is licensed under the Apache License. 
