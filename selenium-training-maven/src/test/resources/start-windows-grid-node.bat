java -Dwebdriver.chrome.driver="chromedriver.exe" ^
-Dwebdriver.edge.driver="msedgedriver.exe" ^
-jar selenium-server-standalone-3.141.59.jar ^
-role node ^
-hub "http://10.37.129.2:4444/grid/register/" ^
-browser "browserName=chrome,platform=Windows,maxInstances=2" ^
-browser "browserName=edge,platform=Windows,maxInstances=2"