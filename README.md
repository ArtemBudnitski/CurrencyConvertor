# Aplikacja Konwerter Walut

| CurrencyConversion | CurrencyList | Search Bar |
|--------------------|--------------------|--------------------|
|![pYNqFGQESOnf_1440_2880](https://github.com/ArtemBudnitski/CurrencyConvertor/assets/126951785/8d908059-e037-4d97-8ab8-f4604e374765)|![DD9nFw9PQYCz_1440_2880](https://github.com/ArtemBudnitski/CurrencyConvertor/assets/126951785/294dea41-f716-43e5-9d49-d24a56aab7a9)|![QlyJAZqqrhkL_1440_2880](https://github.com/ArtemBudnitski/CurrencyConvertor/assets/126951785/1135f7ca-7d6a-48e3-8a39-ecdfa4923013)|


## Struktura Projektu

Projekt składa się z dwóch głównych modułów: konwertera walut (`CurrencyConversion`) i listy walut (`CurrencyList`). Poniżej znajdziesz informacje dotyczące struktury projektu, funkcji, skrótów klawiszowych oraz wykorzystanych technologii w obu modułach.

## Technologie

- Język programowania: Kotlin.
- Wykorzystane technologie: Android Jetpack (Compose, ViewModel, Kotlin Flow), Retrofit do komunikacji z API, Room do lokalnego przechowywania danych, Kotlin Coroutines do obsługi asynchroniczności.

## Moduł Konwertera Walut (`CurrencyConversion`)

### Struktura Projektu

- `com.abudnitski.currencyconversion`: Główny pakiet zawierający klasę `App` (klasa aplikacji Android).
- `com.abudnitski.currencyconversion.presentation.main`: Pakiet zawierający klasy związane z głównym ekranem konwertera walut.
  - `Calculator`: Klasa obsługująca logikę kalkulatora dla konwersji walut.
  - `KeyboardKeys`: Klasa definiująca kody klawiszy kalkulatora.
  - `MainScreenUiState`: Klasa reprezentująca stan UI dla głównego ekranu.

### Funkcje

- Konwerter walut umożliwia użytkownikowi wprowadzanie kwoty w jednej walucie i przeliczanie jej na inną.
- Obsługuje podstawowe operacje matematyczne (dodawanie, odejmowanie, mnożenie, dzielenie).
- Wykorzystuje klasę `Calculator` do przeliczania wartości walut.
- Zastosowano architekturę MVVM z użyciem Android Jetpack.


### Użyte Technologie Zewnętrzne

- API Walutowe: Wykorzystano zewnętrzne API do uzyskania bieżących kursów walut.
- Baza Danych: Dane dotyczące kursów walut są przechowywane lokalnie w bazie danych za pomocą Room.

## Moduł Listy Walut (`CurrencyList`)

### Struktura Projektu

- `com.abudnitski.currencyconversion.presentation.list`: Pakiet zawierający klasy związane z listą walut.
  - `ListViewModel`: Klasa ViewModel dla ekranu listy walut.
  - `ListUiState`: Klasa reprezentująca stan UI dla ekranu listy walut.
  - `ListItem`: Klasa reprezentująca pojedynczy element listy walut.
  - `ListUiStateMapper`: Klasa mapująca dane domenowe (waluty) na stan UI.

### Funkcje

- Wyświetla listę dostępnych walut.
- Umieszcza pole wyszukiwania, które filtruje widoczne waluty na podstawie kodu waluty.
- Wykorzystuje `ListUiStateMapper` do mapowania danych walutowych na stan UI.

## Użycie

- Oba moduły korzystają z jednej implementacji `CurrencyMapper`, która mapuje dane walutowe zarówno dla konwertera, jak i listy.

## Licencja

Możesz swobodnie korzystać, modyfikować i rozpowszechniać kod według własnych potrzeb:)
