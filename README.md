# Task 1

#### Hva er utfordringene med dagens systemutviklingsprosess - og hvordan vil innføring av DevOps kunne være med på å løse disse? Hvilke DevOps prinsipper blir brutt?
    Noen av utfordringene med dagens systemutviklingsprosess er at ny funksjonalitet og kode blir pushed veldig 
    sjeldent, og ikke vil det ha vært testet. Det gjør at ofte vil det være feil, så den nye releasen på bli tatt tilbake, 
    som gjør at det kan bli enda flere måneder før ny funksjonalitet kommer på markedet.
    
    Devops løser disse problemene ved at du jobber i en prosess hvor ny funksjonalitet blir laget hele tiden,
    og pushet hver dag (til testing). Den nye koden vil bli testet, og hvis alt er som det skal går det da i 
    produksjon. Da vil kundene ha en mer stabil opplevelse med applikasjonen, og det vil være mulig å fikse feil
    mye oftere, og lettere, når man vet ca. når feilen kom.

    De devops prinsippene som blir brutt i dag er blant annet automation, hvor alt må gjøres manuelt.
    Continous improvement, fordi fikser og nye ting kommer ikke continuously
    Customer-centric, for brukere kan ikke kunne si ifra om feil en gang i halvåret, det blir mye feil, og mye som på en gang må fikses.
    Collaboration, det vil også være veldig vanskelig for alle partene i teamet å jobbe sammen, når utviklere utvikler i en måned,
        så skal en måned med kode testes, og en måned med kode gå i produksjon og bli monitored.

#### En vanlig respons på mange feil under release av ny funksjonalitet er å gjøre det mindre hyppig, og samtidig forsøke å legge på mer kontroll og QA. Hva er problemet med dette ut ifra et DevOps perspektiv, og hva kan være en bedre tilnærming?
    Problemet med dette er at det vil bli vanskeligere og vanskeligere å finne problemene som oppstår, og nye versjoner vil 
    bruke kjempelang tid på å komme i produksjon. 
    En bedre tilnærming kan være på å overlevere ny funksjonalitet hyppig, og i små deler, så alt kan testes lettere, og feil
    kan finnes fortere. Heller fokusere på ´små achievements´.

#### Teamet overleverer kode til en annen avdelng som har ansvar for drift - hva er utfordringen med dette ut ifra et DevOps perspektiv, og hvilke gevinster kan man få ved at team han ansvar for både drift- og utvikling?
    Utfordringen med dette er at drift teamet ikke skjønner koden like godt som kode-teamet. Hvis det da oppstår feil 
    vil det være vanskeligere for dem å finne ut hvorfor. Om kode-teamet har ansvar for drift, vil de fort kunne gjenkjenne
    hvor feil oppstår, og fikse det tidligere.

#### Å release kode ofte kan også by på utfordringer. Beskriv hvilke- og hvordan vi kan bruke DevOps prinsipper til å redusere eller fjerne risiko ved hyppige leveraner.
    Ved å følge devops sirklene vil hyppige leveranser bli lettere å bruke. Hvis development teamet sender koden til et test miljø,
    og hvis ikke godkjent vil den bli fikset og sent igjen, hvis godkjent så sender de videre til release, så blir koden deployed. 
    Så blir appen monitored. Så vil det komme ny kode som allerede har blitt testet og er klar for produksjon komme til release, 
    bli deployed, og er klart til å bli monitored.

# Task 2
    For at ingen skal kunne pushe kode direkte på main må du:
        - Gå til repo
        - Settings
        - Branches
        - Add protection rule
        - Huke av "require a pull request before merging"
            - Dette gjør at du ikke kan pushe direkte til main
        - Huke av "require approvals" under "require a pull request before merging"
            - Dette gjør at noen må godkjenne pull requesten før den merger til main
        - Huke av "Require status checks to pass before merging"
            - Skrive og trykke på "build-and-verify"
            - Dette gjør at build-and-verify må gjøre grønt før du kan merge til main, du kan skrive inn de andre jobbene om det ønskes
        
# Task 3
    For at du skal kunne pushe til egen ecr på eget fork må du:
        - Gå til AWS IAM
        - Users
        - Din bruker
        - Security credentials
        - Create access key
        - Lagre filen
        - Gå på github repoet
        - Settings
        - Secrets
        - Actions
        - New secret
            - Lage en secret som heter AWS_ACCESS_KEY_ID
                - Lime inn din key id fra iam filen
            - Lage en secret som heter AWS_SECRET_ACCESS_KEY
                - Lime inn din key fra iam filen
        - Gå til ECR og lage ditt eget repo
        - Gå til docker.yml filen
        - Finne REPO env variabelen
            - Bytt ut min repo-addresse med din
        - Du må ikke ha :$rev og :latest, men det gjør det lett å finne alle versjonene av imaget du har laget, og å alltid ha en latest, som er fint til f.eks. AppRunner

# Task 5
    Terraform prøver å lage en bucket som heter analytics-jim, men siden det ikke er en state fil på github eller s3 så vil ikke terraform huske at den bucketen allerede er laget

# Extra
    Jeg fikk ikke til å legge til @Timed på dashboard, vises kun om man går til alle metrics -> 1052 -> exception, method osv -> finner med metric name
