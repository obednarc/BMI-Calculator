Projekt będzie wyliczał wskaźnik BMI, przy czym nie jest to jego główne założenie. Skupia się głównie nad administracją danymi użytkownika.
Do skorzystania z niego będzie wymagana rejestracja (login, hasło, email są obowiązkowe)/zalogowanie z zapisem i odczytem z bazy.
Użytkownik ma możliwość wyświetlenia i zmiany swoich danych wprowadzonych przy rejestracji w Panelu Użytkownika, wylogowania się i zalogowania podczas jednej sesji na nowe dane. Dodatkowo program wylicza wskaźnik BMI, na podstawie którego można wstępnie ocenić swój stan zdrowia.

Projekt można rozwijać w dowolny sposób, uwzględniając Spring Security oraz rozwijając kalkulator o zapisywanie i analizowanie wyników w czasie.

-----------------------------------------------

Do uruchomienia projektu:

1) Instalacja Lombok plugin
2) Włączenie Annotation Processing
3) użytkownik bazy MS SQL - ustanowić połączenie VPN z bazą i edytować plik db-template.properties według info w pliku 
4) użytkownik serwera lokalnego/innej bazy - w application.properties, db-template.properties oraz pom.xml zmodyfikować ustawienia bazy danych.
5) localhost:8071

-----------------------------------------------

Przy procesie rejestracji następują ograniczenia:

1) Numer telefonu musi składać się z 9 cyfr.
2) Adres e-mail musi być poprawnie sformatowany.
3) Pola obowiązkowe to: login, hasło, e-mail.

------------------------------------------------

Przykładowe dane do projektu:

LOGIN: anna12
HASŁO: anna123
(podane wszystkie dane)

lub

LOGIN: maciej
HASŁO: maciej
(podane tylko dane obowiązkowe)

lub

dowolne dane po wykonaniu procesu rejestracji (dane zapisują się w bazie na stałe).



