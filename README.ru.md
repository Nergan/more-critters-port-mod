[English](README.md) | [Русский](README.ru.md)

# More Critters

Новые фэнтезийные существа в ванильном стиле для Minecraft 1.21.1 на NeoForge. Это неофициальный порт [More Critters](https://modrinth.com/mod/more-critters) от Portakal_Cevheri.

![логотип](ico.png)

С каждого существа есть польза: еда, ингредиенты для зелий, инструменты, оружие или броня. Кроме существ, мод добавляет странствующего коллекционера, который путешествует в повозке со своим таскожуком и скупает добычу с существ; Атлас существ, справочник по ним; чудиков, маленьких коллекционных созданий, которые эволюционируют на столе эволюции и танцуют под пластинки; окаменелости, которые можно откопать и выставить; корабли-призраки и другие постройки.

Мод полностью переведён на русский, кроме страниц Атласа существ: их текст нарисован прямо в текстурах, на английском.

## Загрузки

GitHub Release `v1.4.5`: [github.com/Nergan/more-critters-port](https://github.com/Nergan/more-critters-port/releases)

| Файл | Нужен | Примечание |
| --- | --- | --- |
| `more_critters-1.4.5.jar` | Да | Этот мод |
| `kotlinforforge-5.8.0-all.jar` | Да | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `geckolib-neoforge-1.21.1-4.9.3.jar` | Да | [GeckoLib](https://modrinth.com/mod/geckolib) |
| `*-sources.jar` | Нет | В `mods` его класть не нужно |

Modrinth: [more-critters-port](https://modrinth.com/project/more-critters-port)

## Требования

- Minecraft 1.21.1
- NeoForge 21.1.209 или новее
- Java 21
- Kotlin for Forge 5.8 или новее
- GeckoLib 4.9.3 или новее

## Установка

Положи `more_critters-1.4.5.jar`, `kotlinforforge-5.8.0-all.jar` и `geckolib-neoforge-1.21.1-4.9.3.jar` в папку `mods`. Мод нужен и на клиенте, и на сервере.

## Конфиг

Серверный конфиг, общий для всех игроков. Файл: `config/more_critters-server.toml` в папке игры (или сервера). Чтобы поменять настройки только для одного мира, положи копию файла в `saves/<мир>/serverconfig/more_critters-server.toml` (на выделенном сервере: `world/serverconfig/more_critters-server.toml`); копия перекрывает файл из `config/`. Экран настроек открывается из списка модов NeoForge.

Оригинальный мод хранил те же настройки в `config/morecritters-general.toml`. Порт этот файл не читает.

| Ключ | По умолчанию | Смысл |
| --- | --- | --- |
| `mobs.can_remove_carrybug_saddle` | `true` | Игроки могут снимать ножницами седло и сундуки с таскожука |
| `mobs.bunbug_birth_number` | `4.0` | Сколько детёнышей рождает жукроль, от 0 до 64 |
| `mobs.snowflake_spider_inflict_frostbite` | `true` | Метельные пауки накладывают обморожение при атаке |
| `mobs.bouncelizard_regular_jump_height` | `0.6` | Скорость, с которой отпрыгущерица подбрасывает вверх приземлившегося на неё, от 0 до 10 |
| `mobs.bouncelizard_sleeping_jump_height` | `1.2` | То же для спящей отпрыгущерицы, от 0 до 10 |
| `mobs.creeblossom_infection_rate` | `30.0` | Монстр в тёплом биоме появляется с эффектом «Цветение» с шансом 1 к N |
| `mobs.warptrap_attack_endermen` | `true` | Искапканы атакуют эндерменов |
| `mobs.shimmerwing_follow_blessed_player` | `true` | Блескокрылы следуют за игроками с эффектом «Благословение энда» |
| `mobs.balloon_rat_poisons_target` | `true` | Мышарики отравляют тех, кто их атакует |
| `mobs.animate_bomb_jelly` | `true` | Текстуры взрывных медуз анимированы |
| `mobs.small_bomb_jelly_explosion_power` | `2.0` | Сила взрыва маленькой взрывной медузы, от 0 до 100. Взрыв не разрушает блоки; у динамита сила 4 |
| `mobs.medium_bomb_jelly_explosion_power` | `3.0` | То же для средней взрывной медузы |
| `mobs.large_bomb_jelly_explosion_power` | `4.0` | То же для большой взрывной медузы |
| `mobs.black_iropod_chance` | `100.0` | Металлопод бывает чёрным с шансом 1 к N |
| `mobs.can_shadelet_jumpscare_player` | `true` | Тенёныши могут пугать игроков скримером |
| `mobs.nervoid_infection_rate` | `50.0` | Эндермен в Энде появляется с эффектом «Эндфекция» с шансом 1 к N |
| `mobs.quartermaster_heal_cooldown` | `150.0` | Сколько тиков мертвец-квартирмейстер ждёт между лечениями (20 тиков = 1 секунда) |
| `mobs.captain_summon_cooldown` | `600.0` | Сколько тиков мертвец-капитан ждёт, прежде чем снова позвать подмогу |
| `mobs.tank_shoot_cooldown` | `200.0` | Сколько тиков мертвец-громила ждёт между выстрелами |
| `items.webbed_requirement` | `50.0` | Паутинный мешок опутывает мобов, у которых максимальное здоровье не больше этого значения |
| `blocks.freezing_cobweb_freeze` | `true` | Леденящая паутина замораживает застрявших в ней мобов |

## Лицензия

Gradle-проект порта, код на Kotlin и обвязка NeoForge — MPL-2.0 (`LICENSE`). Код и ассеты взяты из More Critters и остаются под MIT (`LICENSE-MORE-CRITTERS`, Copyright (c) 2025-2026 Portakal Cevheri). Исходный код оригинала не опубликован; в [`docs/original-license`](docs/original-license/README.md) собраны доказательства того, что мод выпущен под MIT.
