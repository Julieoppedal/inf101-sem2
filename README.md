# SNAKE

I denne oppgaven skal vi implementere Snake.

## Oversikt over arkitektur
Vi vil her først gi et fugleperspektiv av koden vi skal opprette.

Vi baserer modellen vår på design-prinsippet om model-view-controller, hvor vi i størst mulig grad ønsker å skille mellom

- selve logikken og datastrukturene i modellen,
- hvordan modellen vises, og
- hvordan modellen kontrolleres av brukeren.
- I denne guiden deler vi sågar inn koden vår i tre hovedpakker:

I denne guiden deler vi videre inn koden vår i tre hovedpakker: 
 - *inf101.sem2.model*
 - *inf101.sem2.view*
 - *inf101.sem2.controller*

I tillegg vil vi benytte oss av en datastruktur for rutenett som er mer generell, og som skal være i pakken
 - *inf101.sem2.grid*

 Det hele kjøres fra `Main` i pakken *inf101.sem2*, som inneholder main-metoden.


## Modell
For å representere et spill med Snake, er det to hovedelementer vi må holde styr på:
- en orm (en slange) som består av en liste med posisjoner, og
- epler som skal spises av ormen.
Vi identifiserer følgende klasser som egner seg for pakken sem2.model:

- `SnakeModel` en klasse som representerer tilstanden til et komplett spill med Snake. Denne klassen vil ha feltvariabler som representerer orm, mat og poeng.
 - `SnakeBoard` en klasse som representerer et brett med fliser. Dette er i bunn og grunn et rutenett.
- `Snake` en klasse som representerer en slange.
- `Apple` en klasse som representerer mat som ormen skal spise.
Modellen er på mange måter den viktigste delen av koden, og vi ønsker at koden som ligger i modellen er godt testet.

## Visning
For å vise modellen grafisk, lar vi det være en klasse `SnakeView` i pakken snake.view som har som ansvar å tegne Snake-modellen. For å tegne Snake, er planen at SnakeView skal

- tegne slangen (ormen) og
- tegne maten som ormen skal spise.

SnakeView trenger å ha tilgang til modellen for å kunne tegne den, men vi ønsker å begrense tilgangen til modellen for å unngå utilsiktet endring av modellen. Derfor kan vi ha et grensesnitt kalt `ViewableSnakeModel` i pakken inf101.sem2.view som beskriver hvilke metoder SnakeView trenger for å tegne spillet. Vi kan deretter implementere SnakeModel klassen med dette grensesnittet. SnakeView vil ikke vite at den jobber med en SnakeModel, den vil bare vite at den jobber med en ViewableSnakeModel.

## Kontroller
På samme måte som for visningen, kan vi ha en klasse kalt `SnakeController` i pakken inf101.sem2.controller, som vil ha ansvar for å endre modellen basert på input fra brukeren og styre ting som skjer automatisk i spillet, slik som at slangen beveger seg fremover og spawner ny mat. Kontrolleren vil ha behov for tilgang til modellen for å utføre disse oppgavene.

For å begrense tilgangen til modellen, kan vi ha et grensesnitt kalt `ControllableSnakeModel` i pakken inf101.sem2.controller, som beskriver hvilke metoder kontrolleren trenger å endre modellen. Vi kan deretter implementere SnakeModel klassen med dette grensesnittet. SnakeController vil ikke vite at den jobber med en SnakeModel, den vil bare vite at den jobber med en ControllableSnakeModel.


Se [oppgaveteksten](./OPPGAVETEKST.md) til semesteroppgave 2. Denne README -filen kan du endre som en del av dokumentasjonen til programmet, hvor du beskriver for en bruker hvordan programmet skal benyttes.