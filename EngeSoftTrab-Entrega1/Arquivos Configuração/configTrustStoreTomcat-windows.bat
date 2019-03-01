@echo off
setlocal

set CLIENT_CERT=<CAMINHO ONDE ESTÁ A CADEIA DE CONFIANÇA>C:\Endeca\PlatformServices\workspace\etc\eneCert.jks
set CATALINA_OPTS=-Djavax.net.ssl.keyStore=%CLIENT_CERT% 
  -Djavax.net.ssl.keyStorePassword=changeit 
  -Djavax.net.ssl.trustStore=%CLIENT_CERT% 
  -Djavax.net.ssl.trustStorePassword=changeit
cd c:\tomcat\bin
call c:\tomcat\bin\startup.bat
endlocal