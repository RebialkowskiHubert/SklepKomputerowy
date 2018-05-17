-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 23 Maj 2016, 16:22
-- Wersja serwera: 10.1.10-MariaDB
-- Wersja PHP: 5.5.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `sklepkomputerowy`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `administratorzy`
--

CREATE TABLE `administratorzy` (
  `Login` varchar(50) NOT NULL,
  `Haslo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `administratorzy`
--

INSERT INTO `administratorzy` (`Login`, `Haslo`) VALUES
('Hubert', 'kajak'),
('Daniel', 'kajak'),
('Jakub', 'kajak');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `faktury`
--

CREATE TABLE `faktury` (
  `ID_Faktury` int(100) NOT NULL,
  `Nazwa_faktury` varchar(50) NOT NULL,
  `Data_wystawienia` date NOT NULL,
  `ID_Zamówienia` int(100) NOT NULL,
  `ID_Użytkownika` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategorie`
--

CREATE TABLE `kategorie` (
  `ID_Kategorii` int(50) NOT NULL,
  `Nazwa_kategorii` varchar(50) NOT NULL,
  `Opis` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `oferty`
--

CREATE TABLE `oferty` (
  `ID_Oferty` int(100) NOT NULL,
  `Nazwa_oferty` varchar(50) NOT NULL,
  `ID_Użytkownika` int(100) NOT NULL,
  `ID_Produktu` int(100) NOT NULL,
  `Wartość` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkty`
--

CREATE TABLE `produkty` (
  `ID_Produktu` int(50) NOT NULL,
  `Nazwa_produktu` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `ID_Kategorii` int(50) NOT NULL,
  `Cena_produktu` float NOT NULL,
  `Ilosc_na_magazynie` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `raporty`
--

CREATE TABLE `raporty` (
  `ID_Raportu` int(100) NOT NULL,
  `Nazwa_raportu` int(50) NOT NULL,
  `Rodzaj_raportu` int(50) NOT NULL,
  `Data_sporządzenia` date NOT NULL,
  `ID_Użytkownika` int(100) NOT NULL,
  `ID_Zamówienia` int(100) NOT NULL,
  `ID_Produktu` int(100) NOT NULL,
  `ID_Faktury` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `ID_Uzytkownika` int(100) NOT NULL,
  `Imie` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `Haslo_dostepu` text CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `Miejscowosc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `Kod_pocztowy` varchar(6) COLLATE utf8_polish_ci NOT NULL,
  `Ulica` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `Numer_domu` varchar(5) CHARACTER SET latin1 NOT NULL,
  `Numer_lokalu` varchar(5) CHARACTER SET latin1 DEFAULT NULL,
  `Numer_telefonu` varchar(9) CHARACTER SET latin1 DEFAULT NULL,
  `Adres_email` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`ID_Uzytkownika`, `Imie`, `Nazwisko`, `Haslo_dostepu`, `Miejscowosc`, `Kod_pocztowy`, `Ulica`, `Numer_domu`, `Numer_lokalu`, `Numer_telefonu`, `Adres_email`) VALUES
(3, 'Monika', 'Lewinsky', '12', 'Opole', '12-122', 'Polna', '12', '12', '12345678', 'monia@malpa.pl'),
(4, 'das', 'das', 'das', 'das', '11-111', 'das', '1', '1', '123456789', 'das'),
(5, 'Bill', 'Clinton', '123', 'Opole', '12-112', 'Polna', '1', '1', '987654321', 'bill-clinton@gmail.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienia`
--

CREATE TABLE `zamowienia` (
  `ID_Zamowienia` int(100) NOT NULL,
  `ID_Uzytkownika` int(100) NOT NULL,
  `ID_Produktu` int(100) NOT NULL,
  `Ilosc_produktow` int(100) NOT NULL,
  `Data_zamowienia` date NOT NULL,
  `Data_dostawy` date NOT NULL,
  `Cena_dostawy` double NOT NULL,
  `Cena_produktu_i_dostawy` double NOT NULL,
  `Rabat` double NOT NULL,
  `Cena_po_rabacie` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `faktury`
--
ALTER TABLE `faktury`
  ADD PRIMARY KEY (`ID_Faktury`);

--
-- Indexes for table `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`ID_Kategorii`);

--
-- Indexes for table `oferty`
--
ALTER TABLE `oferty`
  ADD PRIMARY KEY (`ID_Oferty`);

--
-- Indexes for table `produkty`
--
ALTER TABLE `produkty`
  ADD PRIMARY KEY (`ID_Produktu`);

--
-- Indexes for table `raporty`
--
ALTER TABLE `raporty`
  ADD PRIMARY KEY (`ID_Raportu`);

--
-- Indexes for table `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`ID_Uzytkownika`);

--
-- Indexes for table `zamowienia`
--
ALTER TABLE `zamowienia`
  ADD PRIMARY KEY (`ID_Zamowienia`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
