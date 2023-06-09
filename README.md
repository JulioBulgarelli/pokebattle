# Poke Battle

![LINE](https://img.shields.io/badge/coverage-99%25-green)

## Funcionalidades
### Consulta de informações de um pokémon
`GET /api/info/{pokemon_name}`

Returns
```json
{
  "name": "rattata",
  "height": 3,
  "weight": 35,
  "locations": [
    "sinnoh-route-225-area",
    "sinnoh-sea-route-226-area",
    "johto-route-29-area",
    "johto-route-30-area",
    "johto-route-31-area",
    "sprout-tower-2f",
    "sprout-tower-3f",
    "johto-route-32-area",
    "union-cave-1f",
    "union-cave-b1f",
    "union-cave-b2f",
    "johto-route-33-area",
    "johto-route-34-area",
    "burned-tower-1f",
    "burned-tower-b1f",
    "bell-tower-2f",
    "bell-tower-3f",
    "bell-tower-4f",
    "bell-tower-5f",
    "bell-tower-6f",
    "bell-tower-7f",
    "bell-tower-8f",
    "bell-tower-9f",
    "johto-route-38-area",
    "johto-route-39-area",
    "johto-route-42-area",
    "mt-mortar-1f",
    "mt-mortar-lower-cave",
    "mt-mortar-b1f",
    "johto-route-46-area",
    "bell-tower-10f",
    "unknown-all-rattata-area",
    "kanto-route-1-area",
    "kanto-route-2-south-towards-viridian-city",
    "kanto-route-3-area",
    "kanto-route-4-area",
    "kanto-route-5-area",
    "kanto-route-6-area",
    "kanto-route-7-area",
    "kanto-route-8-area",
    "kanto-route-9-area",
    "kanto-route-10-area",
    "kanto-route-11-area",
    "kanto-route-16-area",
    "kanto-route-17-area",
    "kanto-route-18-area",
    "kanto-sea-route-21-area",
    "kanto-route-22-area",
    "tohjo-falls-area",
    "pokemon-mansion-1f",
    "pokemon-mansion-2f",
    "pokemon-mansion-3f",
    "pokemon-mansion-b1f",
    "castelia-city-area",
    "castelia-sewers-area",
    "castelia-sewers-unknown-area-38",
    "relic-passage-castelia-sewers-entrance"
  ],
  "stats": {
    "special-attack": 25,
    "defense": 35,
    "attack": 56,
    "hp": 30,
    "special-defense": 35,
    "speed": 72
  },
  "types": [
    "normal"
  ]
}
```


### Linha evolutiva
`GET /api/evolutions/{pokemon_name}`

Returns
```json
{
  "forms": [
    "rattata",
    "raticate"
  ]
}
```

### Batalhas
`POST /api/challenge`

Accepts
```json
{
  "challenger": "jynx",
  "challenged": "pikachu"
}
```

Returns
```json
{
  "winner": "jynx"
}
```
