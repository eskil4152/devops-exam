# Task 1

### 123

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
        - Du kan også huke av "require brances to be up to date before merging" hvis main inneholder kode som ikke er i andre branchen som skal merges
        
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
        - Gå til docker.yml filen
        - Finne REPO env variabelen
            - Bytt ut min repo-addresse med din
        - Du må ikke ha :$rev og :latest, men det gjør det lett å finne alle versjonene av imaget du har laget, og å alltid ha en latest, som er fint til f.eks. AppRunner

# Task 5
    Terraform prøver å lage en bucket som heter analytics-jim, men siden det ikke er en state fil på github eller s3 så vil ikke terraform huske at den bucketen allerede er laget
