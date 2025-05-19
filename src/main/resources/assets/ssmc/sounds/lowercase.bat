@echo off
setlocal enabledelayedexpansion

:: ���������� ��������������� ��� ����� �������
for /f "delims=" %%d in ('dir /ad /b /s ^| sort /r') do (
    set "dirname=%%~nxd"
    set "lower=!dirname!"
    
    :: ����������� ��� ����� � ������ �������
    call :ToLower lower
    
    :: ���� ��� ����������, ���������������
    if not "!dirname!"=="!lower!" (
        ren "%%d" "!lower!"
    )
)

:: ����� ���������� ��������������� ��� �����
for /r %%f in (*) do (
    set "filename=%%~nxf"
    set "lower=!filename!"
    
    :: ����������� ��� ����� � ������ �������
    call :ToLower lower
    
    :: ���� ��� ����������, ���������������
    if not "!filename!"=="!lower!" (
        ren "%%f" "!lower!"
    )
)

echo ��� ����� ������ � ����� ���� ��������� � ������� ��������.
pause
exit /b

:ToLower
:: ������� ��� �������������� ������ � ������ �������
setlocal
set "str=!%1!"
set "result="

for /l %%i in (0,1,1000) do (
    set "char=!str:~%%i,1!"
    if "!char!"=="" goto :done
    for %%c in (A B C D E F G H I J K L M N O P Q R S T U V W X Y Z) do (
        if "!char!"=="%%c" set "char=%%c"
    )
    set "result=!result!!char!"
)
:done
endlocal & set "%1=%result%"
goto :eof