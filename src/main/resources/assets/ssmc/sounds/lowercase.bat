@echo off
setlocal enabledelayedexpansion

:: Рекурсивно переименовываем все папки сначала
for /f "delims=" %%d in ('dir /ad /b /s ^| sort /r') do (
    set "dirname=%%~nxd"
    set "lower=!dirname!"
    
    :: Преобразуем имя папки в нижний регистр
    call :ToLower lower
    
    :: Если имя изменилось, переименовываем
    if not "!dirname!"=="!lower!" (
        ren "%%d" "!lower!"
    )
)

:: Затем рекурсивно переименовываем все файлы
for /r %%f in (*) do (
    set "filename=%%~nxf"
    set "lower=!filename!"
    
    :: Преобразуем имя файла в нижний регистр
    call :ToLower lower
    
    :: Если имя изменилось, переименовываем
    if not "!filename!"=="!lower!" (
        ren "%%f" "!lower!"
    )
)

echo Все имена файлов и папок были приведены к нижнему регистру.
pause
exit /b

:ToLower
:: Функция для преобразования строки в нижний регистр
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