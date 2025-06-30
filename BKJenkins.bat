@echo off
cd /d "D:\Core Modules\Capium_BK_3.0"

echo ========================
echo Running Maven Cucumber...
echo ========================

mvn clean test -Dsurefire.suiteXmlFiles=testsuite.xml -Dfile.encoding=UTF-8

pause
