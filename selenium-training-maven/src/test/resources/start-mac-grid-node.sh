java -Dwebdriver.chrome.driver="/usr/local/bin/chromedriver" \
-jar selenium-server-standalone-3.141.59.jar \
-role node \
-hub http://10.37.129.2:4444/grid/register/ \
-browser "browserName=chrome,platform=MacOS,maxInstances=3" \
-browser "browserName=safari,platform=MacOS,maxInstances=3"