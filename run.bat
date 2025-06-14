@echo off
setlocal

REM Check if Main.java exists to ensure we're in the right folder
if not exist Main.java (
    echo Please run this script from the project root folder where Main.java is located.
    pause
    exit /b
)

echo =============================
echo Cleaning previous build...
echo =============================

if exist Out rmdir /S /Q Out

echo =============================
echo Creating output folder...
echo =============================

mkdir Out

echo =============================
echo Compiling the game...
echo =============================

javac -d Out -cp . Main.java game\*.java logic\*.java UI\*.java music\*.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ❌ Compilation failed! Please fix errors and try again.
    pause
    exit /b
)

echo =============================
echo Copying resources...
echo =============================

xcopy /S /E /I /Y music Out\miniUndertaleGame\music
xcopy /S /E /I /Y logos Out\miniUndertaleGame\logos

echo =============================
echo Running the game!
echo =============================

java -cp Out miniUndertaleGame.Main

pause
endlocal

