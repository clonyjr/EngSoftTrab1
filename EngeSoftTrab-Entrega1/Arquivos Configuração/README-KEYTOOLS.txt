keytool -import -trustcacerts -alias myselfsignedcert -file /Users/me/Desktop/selfsignedcert.crt -keystore ./privateKeystore.jks
keytool -importkeystore -srckeystore <java-home>/lib/security/cacerts -destkeystore ./privateKeystore.jks

sudo keytool -import -trustcacerts -alias openskycert -keystore java_home/Contents/Home/jre/lib/security/cacerts -file /Users/clonyjr/opensky-network.org.cer

keytool -importkeystore -srckeystore java_home/Contents/Home/jre/lib/security

--WINDOWS
keytool -import -trustcacerts -alias openskycert -keystore %JAVA_HOME%/jre/lib/security/cacerts -file <CAMINHO DO LOCAL ONDE ESTÁ O CERTIFICADO>/opensky-network.org.cer

keytool -importkeystore -srckeystore java_home/jre/lib/security

keytool -import -file <CAMINHO ONDE ESTÁ O CERTIFICADO>opensky-networkorg.crt -alias airlocation -keystore airLocationTrustStore