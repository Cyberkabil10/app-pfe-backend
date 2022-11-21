@ECHO OFF & SETLOCAL
set ReleaseVersion=1.0.2

for /F "tokens=1,2,3 delims=." %%a in ("%ReleaseVersion%") do (
   set Major=%%a
   set Minor=%%b
   set Revision=%%c
)

echo  %Major%,%Minor%,%Revision% > Version.txt