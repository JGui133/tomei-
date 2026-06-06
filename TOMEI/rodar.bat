@echo off
cd /d "%~dp0"
echo Compilando...
javac --release 17 *.java
if errorlevel 1 (
    echo.
    echo ERRO na compilacao. Verifique se o Java JDK esta instalado.
    echo Tente: "C:\Program Files\Java\jdk-25.0.2\bin\javac" --release 17 *.java
    pause
    exit /b 1
)
echo.
echo Executando Main...
echo.
java Main
echo.
pause
