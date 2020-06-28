Projekt będzie wyliczał wskaźnik BMI, przy czym nie jest to jego główne założenie. Skupia się głównie nad administracją danymi użytkownika.
Do skorzystania z niego będzie wymagana rejestracja (login, hasło, email są obowiązkowe)/zalogowanie z zapisem i odczytem z bazy.
Użytkownik ma możliwość wyświetlenia i zmiany swoich danych wprowadzonych przy rejestracji w Panelu Użytkownika, wylogowania się i zalogowania podczas jednej sesji na nowe dane. Dodatkowo program wylicza wskaźnik BMI, na podstawie którego można wstępnie ocenić swój stan zdrowia.

Projekt można rozwijać w dowolny sposób, na wstępie uwzględniając Spring Security.


Do uruchomienia projektu:
1) Instalacja Lombok plugin
2) Włączenie Annotation Processing
3) użytkownik bazy MS SQL - ustanowić połączenie VPN z bazą i edytować plik db-template.properties według info w pliku 
4) użytkownik serwera lokalnego/innej bazy - w application.properties, db-template.properties oraz pom.xml zmodyfikować ustawienia bazy danych.
5) localhost:8071



