-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `id_consulta` bigint NOT NULL AUTO_INCREMENT,
  `avaliacao` longtext NOT NULL,
  PRIMARY KEY (`id_consulta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,'Melhor estabelecimento!!');
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `preco` varchar(10) NOT NULL DEFAULT 'R$00,00',
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (7,'Analgésico Aspirina Adulto 500mg Bayer 10 Comprimidos','R$9.8',1);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_avaliacao`
--

DROP TABLE IF EXISTS `historico_avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_avaliacao` (
  `id_consulta` bigint NOT NULL,
  `avaliacao` longtext NOT NULL,
  PRIMARY KEY (`id_consulta`),
  CONSTRAINT `historico_avaliacao_ibfk_1` FOREIGN KEY (`id_consulta`) REFERENCES `consulta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_avaliacao`
--

LOCK TABLES `historico_avaliacao` WRITE;
/*!40000 ALTER TABLE `historico_avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_consulta`
--

DROP TABLE IF EXISTS `historico_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_consulta` (
  `id_consulta` bigint NOT NULL,
  `nome` longtext NOT NULL,
  `preco` varchar(10) NOT NULL DEFAULT 'R$ 00,00',
  PRIMARY KEY (`id_consulta`),
  CONSTRAINT `historico_consulta_ibfk_1` FOREIGN KEY (`id_consulta`) REFERENCES `consulta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_consulta`
--

LOCK TABLES `historico_consulta` WRITE;
/*!40000 ALTER TABLE `historico_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `nome` varchar(150) NOT NULL,
  `sintoma` varchar(30) NOT NULL,
  `principio_ativo` varchar(50) NOT NULL,
  `modo_uso` varchar(30) NOT NULL,
  `problema` varchar(30) NOT NULL,
  `partes_do_corpo` varchar(50) NOT NULL,
  `classificacao` varchar(20) NOT NULL,
  `descricao` longtext NOT NULL,
  `preco` float NOT NULL,
  `estoque` int NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES ('Adesivo Salonpas Pequeno 10 Unidades','Dor muscular','Cânfora','Via tópica','Para dor','Para os musculos','Anti-inflamatórios','O Adesivo Salonpas Pequeno é indicado para o tratamento de dores lombares, musculares, contusões, pancadas, nas costas, \ndentre outros. O produto possui ação analgésica e anti-inflamatória, que alivia o inchaço e as dores. A embalagem contém 10 unidades.',8.63,100),('Alivium 400mg Mantecorp Farmasa 20 Cápsulas Moles','Dor muscular','Ibuproveno','Via oral','Para artrite','Para as articulações','Analgésicos','Alivium 400mg Cápsulas Líquidas (ibuprofeno) é um analgésico rápido e eficaz. Possui atividade analgésica, antitérmica e \nanti-inflamatória. A partir de 10 minutos, ele alivia febres e dores de leve a moderada intensidade, tais como: dores nas costas, de cabeça, \nmusculares, cólicas, sintomas de gripes e resfriados comuns, dor de artrite e dor de dente. Por ser uma capsula líquida, não existe o processo \nde dissolução do medicamento. Portanto, Alivium Cápsulas Líquidas é absorvido pelo organismo de forma mais rápida e vai direto ao foco da dor. \nNão usar este medicamento se houver história anterior de alergia ao ibuprofeno ou a qualquer componente da fórmula.Não deve ser usado durante os \núltimos 3 meses de gravidez. Este medicamento é contraindicado para menores de 12 anos.',28.9,100),('Analgésico Advil Mulher 400mg 10 Cápsulas','Cólica','Ibuprofeno','Via oral','Para dor de cabeça','Para coluna','Analgésicos','Advil Mulher é forte contra as cólicas menstruais¹, e suave para o estômago². Possui a avançada tecnologia das cápsulas \nlíquidas que é absorvida rapidamente³, a partir de 10 minutos5, aliviando também dores relacionadas ao período menstrual como dor de cabeça, \nenxaqueca, dor nas costas e dor nas pernas4. Vide bula do produto. POR QUE ADVIL MULHER? • Advil Mulher faz parte da linha de Advil, analgésico \nnúmero 1 do mundo6 e primeiro analgésico do mercado7 com a inovadora tecnologia das cápulas líquidas, para o combate rápido da dor, sendo suave\nno estômago. FORMATO: • Contém 10 cápsulas líquidas. Advil Mulher 400mg contém 2 tamanhos disponíveis, caixa com 10 cápsulas líquidas e blister \nindividual com 2 cápsulas líquidas. INDICAÇÃO: • Indicado no alívio de cólica menstrual e dores relacionadas ao período menstrual, como dor nas \ncostas, dor de cabeça, enxaqueca e dor nas pernas4. MODO DE USO: Deve ser administrado por via oral na dose recomendada de 1 cápsula. Se necessário, \nessa dose pode ser repetida, com intervalo mínimo de 4-6 horas. Não exceder o total de 3 cápsulas em um período de 24 horas. Pode ser administrado \ncom alimentos. ADVIL MULHER 400MG. SE PERSISTIREM OS SINTOMAS, O MÉDICO DEVERÁ SER CONSULTADO. Advil Mulher - ibuprofeno 400 mg. Nº Reg.: 1.2110.0455. \nIndicações: alívio temporário da febre e de dores leves a modoradas como: de cabeça, nas costas, muscular, de artrite, de dente, enxaqueca, \ncólica menstrual, de gripes e resfriados comuns. NÃO DEVE SER UTILIZADO POR MULHERES GRÁVIDAS SEM ORIENTAÇÃO MÉDICA. INFORME IMEDIATAMENTE SEU MÉDICO \nEM CASO DE SUSPEITA DE GRAVIDEZ. LEIA A BULA.',18.68,100),('Analgésico Aspirina Adulto 500mg Bayer 10 Comprimidos','Dor de cabeça','Ácido acetilsalicílico','Via oral','Para dor','Para sistema nervoso','Analgésicos','Aspirina - ácido acetilsalicílico 500mg² Aspirina é o medicamento da Bayer que tem ação analgésica, antitérmica e anti-inflamatória e \né indicado há mais de 100 anos para o alívio da dor.',9.8,100),('Analgésico Aspirina C 400mg Bayer Limão 2 Comprimidos','Dor de garganta','Ácido acetilsalicílico','Via oral','Para dor','Para sistema nervoso','Analgésicos','Aspirina - ácido acetilsalicílico 500mg² Aspirina é o medicamento da Bayer que tem ação analgésica, antitérmica e anti-inflamatória \ne é indicado há mais de 100 anos para o alívio da dor.',7.99,100),('Analgésico Dorflex 10 Comprimidos','Dor de cabeça','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','Dorflex possui ação analgésica e relaxante muscular. O início da ação ocorre a partir de 30 minutos. Dorflex é indicado no \nalívio da dor associada a contraturas musculares, incluindo dor de cabeça tensional.',6.85,100),('Analgésico Dorflex 36 Comprimidos','Dor muscular','Dipirona monoidratada','Via oral','Para dor','Para o sistema nervoso','Analgésicos','Dorflex possui ação analgésica e relaxante muscular. O início da ação ocorre a partir de 30 minutos. Dorflex é indicado \nno alívio da dor associada a contraturas musculares, incluindo dor de cabeça tensional.',6.85,100),('Analgésico Flanax 550mg Bayer 10 Comprimidos','Dor muscular','Naproxeno sódico','Via oral','Para dor','Para os musculos','Analgésicos','Flanax 550mg (naproxeno) utilizado para alívio da dor, febre e inflamação. Pode ser utilizado para tratar dores de garganta, \ndor e febre decorrente de gripes e resfriados, dor de dente, abdominal, dores musculares, articulares e outras. Sua ação inicia-se cerca de 20 \nminutos após administração oral.',24.59,100),('Analgésico Novalgina 1g 10 Comprimidos','Dor de cabeça','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','O Analgésico Novalgina 1g 10 Comprimidos (dipirona) é indicado para o tratamento da febre e de dores, inclusive as intensas. \nSua ação inicia-se de 30 a 60 minutos após administração oral e seus efeitos duram por aproximadamente 4 horas.',24.49,100),('Analgésico Tylenol Criança 160Mg/5Ml 60Ml','Febre','Paracetamol','Via oral','Para dor','Para articulação','Analgésicos','TYLENOL Criança é um analgésico com o princípio ativo de Paracetamol e é indicado para crianças acima de 2 anos e alivia rapidamente \ndores leves e moderadas comuns deste período de vida, como dores associadas a gripes e resfriados comuns, dor de cabeça, dor de dente e dor de garganta. \nA embalagem contém 60mL de paracetamol com concentração de 32mg/mL com sabor de frutas e 1 copo-medida dose por kg da criança',28.15,100),('Antiácido Gastrol 20 Pastilhas Mastigáveis','Dor de estômago','Carbonato de cálcio','Via oral','Para azia','Para estômago','Antiácidos','Gastrol é um medicamento que atua no combate da hiperacidez gástrica e dos desconfortos de ordem gastroduodenal, decorrentes \ndesta, como azia, queimação e má digestão. Tem eficácia imediata, uma vez que rapidamente reage com os ácidos do estômago, neutralizando a \nacidez do estômago.',11.67,100),('Antiácido LuftaGastroPro Frasco 150ml','Dor de estômago','Alginato de sódio','Via oral','Para refluxo','Para estômago','Antiácidos','LuftaGastroPro é um medicamento indicado para aliviar os sintomas de refluxo, como de azia e queimação, causados pela má digestão. \nCom ação mecânica, sem absorção pelo organismo, age por meio da formação de uma barreira de ácido algínico no topo do estômago, proporcionando \nalívio rápido e de longa duração. Pode ser utilizado por gestantes, sob orientação médica.',22.39,100),('Antigripal Benegrip 12 Comprimidos','Febre','Ácido acetilsalicílico','Via oral','Para gripe','Para garganta','Antigripais','Benegrip é um antigripal que alivia os sintomas de gripes e resfriados tais como: dores de cabeça, febre e processos alérgicos, \ncomo nariz entupido. A ação completa de Benegrip está na dupla verde e amarela de comprimidos: um não funciona sem o outro.',19.27,100),('Antigripal Benegrip 20 Comprimidos','Gripe','Cafeína','Via oral','Para gripe','Para sistema respiratório','Antigripais','Benegrip é um antigripal que alivia os sintomas de gripes e resfriados tais como: dores de cabeça, febre e processos alérgicos, como \nnariz entupido. A ação completa de Benegrip está na dupla verde e amarela de comprimidos: um não funciona sem o outro.',27.99,100),('Antigripal Benegrip 6 Comprimidos','Gripe','Cafeína','Via oral','Para gripe','Para sistema imune','Analgésicos','Benegrip é um antigripal que alivia os sintomas de gripes e resfriados tais como: dores de cabeça, febre e processos alérgicos, \ncomo nariz entupido. A ação completa de Benegrip está na dupla verde e amarela de comprimidos: um não funciona sem o outro.',11.88,100),('Apracur Duo 20 Comprimidos','Febre','Dipirona monoidratada','Via oral','Para gripe','Para sistema respiratório','Analgésicos','Antigripal Apracur é utilizado no tratamento de gripe, resfriado, dores de cabeça, febre, neuralgias, mialgias, dores \nreumáticas e distúrbios de estado geral causados por alterações climáticas e abuso de álcool ou nicotina.',14.39,100),('Atroveran Dip 1g 4 Comprimidos','Cólica','Dipirona','Via oral','Para dor','Para cólica','Analgésicos','O que é: Atroveran Dip 1g é recomendado contra dores e cólicas moderadas e fortes. Prático para ter sempre na bolsa. Para que serve: \nAtroveran Dip 1g é indicado com analgésico (para dor), antitérmico (para febre) e para alívio das cólicas. Modo de usar: Tomar 1 Comprimido até 4x \nao dia.',5.4,100),('Benalet Menta Johnson\'s 12 Pastilhas','Dor de garganta','Citrato de sódio','Via oral','Para infecções','Para garganta','Antialérgicos','Benalet é um tratamento adjuvante (auxiliar) nos quadros de afecções das vias aéreas superiores como tosse, irritação da \ngarganta e faringite.',13.55,100),('Benegrip Multi Solução 240ml','Gripe','Cloridrato de fenilefrina','Via oral','Para gripe','Para sistema respiratório','Analgésicos','Benegrip Multi é o antigripal líquido infantil, indicado para crianças a partir de 2 anos de idade, que combate os \nsintomas de gripe e resfriado, como febre, dor e nariz entupido. Não é xarope para tosse, é antigripal líquido.',29.2,100),('Buscofem 400mg 10 Cápsulas','Cólica','Ibuprofeno','Via oral','Para cólica','Para corpo','Analgésicos','Buscofem 400mg é indicado para tratar sintomas de febre e dores leves e moderadas associadas a gripes e resfriados; \nfaringite, enxaqueca, dor de dente, dor nas costas, dores musculares, dores articulares e cólicas menstruais. Sua ação inicia-se 20 \nminutos após uso e perdura de 4 a 6 horas.',25.38,100),('Chá Vick Pyrena 500mg Mel e Limão 5 Envelopes 5g','Gripe','Paracetamol','Via oral','Para gripe','Para sistema imunológico','Analgésicos','O Chá Vick Pyrena 500mg Mel e Limão 5 Envelopes 5g tem como princípio ativo o paracetamol , que eleva o limiar da dor e \nregula a temperatura através de sua ação no sistema nervoso. Seu efeito tem início 15 a 30 minutos após a administração oral e permanece \npor um período de 4 a 6 horas. Vick Pyrena é contra indicado para pacientes alérgicos ao paracetamol ou a qualquer componente do produto. \nNão use Vick Pyrena caso tenha doença no fígado ou rins.',15.65,100),('Ciflogex Diet Cimed 12 Pastilhas','Dor de garganta','Cloridrato de benzidamina','Via oral','Para dor','Para garganta','Anti-inflamatórios','Ciflogex Diet Cimed 12 Pastilhas (cloridrato de benzidamina) é utilizado no tratamento de inflamações localizadas \nna boca e garganta; de afecções como gengivites, estomatites e doenças periodontais; faringites, laringites e outras. Uso adulto e pediátrico.',13.2,100),('Cimegripe 400mg Cimed 20 Cápsulas','Congestão nasal','Paracetamol','Via oral','Para gripe','Para sistema nervoso','Analgésicos','Cimegripe 400mg Cimed é indicado no tratamento dos sintomas de gripes e resfriados. Cimegripe é destinado ao alívio da \ncongestão nasal, coriza, febre, dor de cabeça e dores musculares presentes nos estados gripais. Cimegripe atua a nível de Sistema Nervoso \nCentral promovendo a diminuição da febre e da sensibilidade à dor. Além disso, bloqueia a liberação de certas substâncias responsáveis \npelos efeitos alérgicos, diminuindo edema, coriza e rinite, possibilitando o descongestionamento nasal. O início do efeito ocorre em 15 \nminutos após a administração.',15.39,100),('Decongex Plus Aché Revestido - 12 Comprimidos','Gripe','Cloridrato de fenilefrina','Via oral','Para coriza','Para garganta','Analgésicos','Decongex Plus Ache Comprimido é um medicamento destinado ao controle e alívio dos sintomas relacionados com gripes, \nresfriados e rinossinusites de origem alérgica ou infecciosa, produzindo um rápido efeito descongestionante nasal, diminuindo as secreções \nexcessivas. O maleato de bronfeniramina, um anti-histamínico associado às aminas simpaticomiméticas reduz efetivamente a secreção nasofaríngea \ne diminui o edema e congestão do aparelho respiratório.',22.91,100),('Decongex Plus Aché Xarope - 120ml','Congestão nasal','Cloridrato de fenilefrina','Via oral','Para coriza','Para garganta','Antialérgicos','Decongex Plus Ache Xarope é um medicamento destinado ao controle e alívio dos sintomas relacionados com gripes, \nresfriados e rinossinusites de origem alérgica ou infecciosa, produzindo um rápido efeito descongestionante nasal, diminuindo as \nsecreções excessivas. O maleato de bronfeniramina, um anti-histamínico associado às aminas simpaticomiméticas reduz efetivamente a \nsecreção nasofaríngea e diminui o edema e congestão do aparelho respiratório. Após a sua administração por via oral, o maleato de \nbronfeniramina é absorvido pelo trato gastrintestinal, apresentando um pico sérico de 2 a 5 horas.',17.22,100),('Descongestionante Nasal Salsep Jet Kids 100ml','Congestão nasal','Cloreto de sódio','Via nasal','Para congestão nasal','Para sistema respiratório','Descongestionantes','Salsep® Jet Kids 100mL foi pensado especialmente para a limpeza nasal profunda de \nbebês e crianças, com uma aplicação 360º, é o único jato contínuo infantil com bico anatômico e fixo ao frasco, o que promove uma maior \nsegurança e conforto para o paciente. Indicado como fluidificante e descongestionante nasal, seu jato promove uma ação mecânica, ou seja, \narrasta as impurezas para o fundo do nariz, auxiliando no tratamento e na prevenção de gripes, resfriados, sinusites e outras doenças \nrespiratórias. Seu uso é individualizado e, por isso, possui área para marcação do nome do usuário no frasco e na caixa. Modo de Uso: \nAplique a solução nas narinas, conforme necessidade. Antes de utilizar este medicamento, leia as instruções na bula.',29.49,100),('Descongestionante Vick VapoRub 12g','Gripe','Levomentol','Via tópica','Para tosse','Para sistema respiratório','Descongestionantes','Vick Vaporub 12g libera três ingredientes ativos, os quais são inalados pelo paciente para proporcionar alívio da tosse, \ncongestão nasal e mal-estar muscular que acompanham as gripes e resfriados. Ao passar, ou fazer inalação com Vick Vaporub, os vapores dos óleos \nessenciais que o compõem, agem nos receptores das vias aéreas superiores, promovendo o alívio da descongestão nasal e da tosse. A massagem realizada \nao passar o medicamento nas costas aquece a região, promovendo o alívio do desconforto muscular.',11.87,100),('Diclofenaco de Dietilamônio Gel 11,6mg/g Genérico Medley 60g','Dor muscular','Diclofenaco','Via tópica','Para dor','Para os musculos','Anti-inflamatórios','Diclofenaco de Dietilamônio Gel 11,6mg/g Genérico Medley 60g é um medicamento anti-inflamatório tópico que age sobre a região \ninflamada aliviando o inchaço e a dor. A formulação deste medicamento foi desenvolvida especialmente para ser friccionada sobre a pele. A substância \nativa, o diclofenaco dietilamônio, pertence ao grupo dos medicamentos chamados anti-inflamatórios não-esteroidais. Não utilize este medicamento se \nvocê estiver grávida ou estiver amamentando. Procure a orientação de um médico caso você necessite tomar qualquer medicamento.',16.66,100),('Dipirona Sódica + Cloridrato de Isometepteno + Cafeína Genérico Prati Donadutti 15ml Gotas','Cólica','Cafeína','Via oral','Para dor','Para cabeça','Analgésicos','A Dipirona Sódica + Cloridrato de Isometepteno + Cafeína Genérico Prati Donadutti 15ml Gotas tem efeito analgésico \ne antiespasmódico. Com fórmula à base de 3 princípios ativos, é indicada para o tratamento de vários tipos de dor de cabeça e cólicas, pois ajuda \na diminuir a dor e a contração involuntária. A dipirona diminui a sensibilidade para a dor, o isometepteno reduz a dilatação dos vasos sanguíneos \ncerebrais para diminuir a dor e potencializar o efeito analgésico e antiespasmódico, e a cafeína estimula o sistema nervoso central e diminui o \ncalibre dos vasos sanguíneos para aliviar a dor de cabeça. A Dipirona Sódica + Cloridrato de Isometepteno + Cafeína Genérico Prati Donadutti 15ml \nGotas geralmente surte efeito após 15 ou 30 minutos de administração oral e dura de 4 a 6 horas.',0,0),('Dipirona Sódica 500mg Genérico EMS 10 Comprimidos','Dor de cabeça','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','A Dipirona Sódica é à base de dipirona, utilizado no tratamento da dor e febre. Os efeitos analgésico e antitérmico podem ser esperados\nem 30 a 60 minutos após a administração e geralmente persistem por aproximadamente 4 horas.',4.39,100),('Doralgina Neo Química 10 Drágeas','Febre','Dipirona monoidratada','Via oral','Para dor','Para corpo','Analgésicos','Um dos princípios ativos da Doralgina é a Dipirona. Uma das funções da Dipirona é abaixar a febre. Portanto, a Doralgina \nconsegue abaixar a febre.',6.83,100),('Doril Enxaqueca 18 Comprimidos','Dor de cabeça','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','Este medicamento atua como um analgésico com ação antipirética tendo, portanto, a capacidade de aliviar a dor e a febre. \nPor possuir a substância cafeína este medicamento também tem a capacidade de aumentar a ação de alguns analgésicos (medicamentos para a dor), \ncomo é o caso da própria dipirona.',29.28,100),('Droxaine Suspensão 240ml','Dor de estômago','Hidróxido de alumínio','Via oral','Para gastrite','Para estômago','Antiácidos','Droxaine é um medicamento destinado ao tratamento de acidez estomacal, azia, desconforto estomacal, dor de estômago, dispepsia, \nepigastralgia, má digestão, queimação, pirose, esofagite péptica e distensão abdominal.',37.99,100),('Enxaguante Bucal Malvatricin 250ml','Dor de garganta','Tirotricina + Sulfato de Hidroxiquinolina','Via oral','Para infecções','Para garganta','Antissépticos','O Enxaguante Bucal Malvatricin também auxilia na prevenção das cáries dentárias, na proteção das gengivas e na purificação do \nhálito. É recomendado seu uso diariamente, pois não agride e nem resseca a mucosa bucal, evitando sua descamação ou outros efeitos indesejados. \nSua fórmula com Malva e Xilitol e outros componentes naturais, é extremamente benéfica para a saúde bucal. Obtenha um sorriso saudável e bonito, \nalém de um hálito super fresco, com o Enxaguante Bucal Malvatricin.',32.97,100),('Gaviscon 8 Cápsulas','Dor de estômago','Alginato de sódio','Via oral','Para digestão','Para estômago','Antiácidos','Gaviscon é um medicamento indicado para o tratamento de indigestão, queimação e desconforto estomacal (associados à indigestão), azia, \ndispepsia, enjôo, náusea e vômito.',0,0),('Gel Dental Malvatricin 50g','Dor de garganta','Tirotricina + Sulfato de Hidroxiquinolina','Via oral','Para infecções','Para garganta','Antissépticos','Gel dental Malvatricin é um gel antisséptico que combate afecções da boca e garganta, como aftas, além de proporcionar dentes \nbrancos e hálito puro.',32.17,100),('Lisador Dip 1g 10 Comprimidos','Febre','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','O Lisador Dip 1g 10 Comprimidos é um medicamento à base de dipirona monoidratada, destinado para os casos dor e febre. \nComo ele Funciona: O Lisador Dip é um medicamento à base de dipirona utilizado no tratamento da dor e febre. O tempo médio de início de ação \né de 30 a 60 minutos após a administração e geralmente dura aproximadamente 4 horas. Quando não devo Utilizar: Este medicamento é contraindicado \nem caso de alergia ou intolerância à dipirona ou a qualquer um dos componentes da fórmula. Qual a melhor forma de guardar: Conservar na embalagem \noriginal e em ambiente com temperatura entre 15 e 30º C, protegido da luz.',15.9,100),('Luftafem 12 Comprimidos','Cólica','Ibuprofeno','Via oral','Para cólica','Para cabeça','Analgésicos','Luftafem é um medicamento de dupla ação analgésica, indicado para cólicas menstruais e outras dores, com início de \nabsorção em 5 minutos e efeito por até 9 horas.',26.47,100),('Magnésia Bisurada 40 Pastilhas','Dor de estômago','Carbonato básico de bismuto','Via oral','Para azil','Para estômago','Antiácidos','Magnésia Bisurada 40 Pastilhas é um antiácido que tem como função principal neutralizar o excesso de ácido produzido pelo \nestômago. Desta forma, Magnésia Bisurada diminui a acidez estomacal, promovendo alívio imediato dos sintomas como azia, queimação e dor de \nestômago. Magnésia Bisurada não deve ser utilizada por pessoas com hipersensibilidade (alergia) aos componentes da fórmula, na presença de \nhipercalcemia (nível elevado de cálcio no sangue) e distúrbios renais graves.',35.33,100),('Malvona Solução Oral 100ml','Dor de garganta','Borato de sódio','Via oral','Para infecções','Para garganta','Antissépticos','Malvona Solução Oral 100ml conta com propriedades antissépticas e anestésicas, sendo indicado para alívio sintomático da \ndor de garganta e tratamento de afecções da boca, gengiva e garganta. Deve ser diluído em água para uso por meio de bochecho ou gargarejos. \nUso adulto.',19.29,100),('Melhoral Infantil 8 Comprimidos','Febre','Ácido acetilsalicílico','Via oral','Para dor','Para sistema imune','Analgésicos','O Melhoral Infantil é um analgésico e anti-inflamatório indicado para tratar dores e febres, inclusive sintomas de gripes e resfriados, \nseguro para ser usado por crianças, fácil de tomar e sabor agradável.Uso pediátrico a partir de 1 ano.',6.35,100),('Multigrip 20 Cápsulas','Congestão nasal','Paracetamol','Via oral','Para gripe','Para sistema nervoso','Antigripais','Multigrip 20 Cápsulas é indicado no tratamento dos sintomas de gripes e resfriados. Destinado ao alívio da congestão \nnasal, coriza, febre, dor de cabeça e dores musculares presentes nos estados gripais. Além disso, bloqueia a liberação de certas substâncias \nresponsáveis pelos efeitos alérgicos, diminuindo edema, coriza e rinite, possibilitando o descongestionamento nasal. O início do efeito ocorre \nem 15 minutos após a administração. MultiGrip® é contraindicado para pacientes com hipersensibilidade aos componentes da fórmula, pressão alta, \ndoença cardíaca, diabetes, glaucoma, hipertrofia da próstata, doença renal crônica, insuficiência hepática grave, disfunção tireoidiana, gravidez \ne lactação sem controle médico.',24.17,100),('Neolefrin 20 Comprimidos','Congestão nasal','Cloridrato de fenilefrina','Via oral','Para dor','Para sistema imunológico','Analgésicos','O Neolefrin 20 Comprimidos é um analgésico e antitérmico indicado para o tratamento dos sintomas das gripes, resfriados, \ndor, febre, congestão nasal e coriza. Como ele funciona: Neolefrin age aliviando a dor e febre decorrentes de quadros infecciosos das \nvias aéreas superiores. As ações destes três princípios ativos aliviam os sintomas associados às gripes e resfriados. Neolefrin possui \ninício de ação 30 minutos após a ingestão. Quando não devo utilizar: Este medicamento é contraindicado para pacientes alérgicos a algum \ndos componentes da fórmula. Qual a melhor forma de guardar: Conservar na embalagem original e em ambiente com temperatura entre 15 e 30º C, \nprotegido da luz e umidade.',8.79,100),('Neosaldina 20 drágeas','Dor de cabeça','Dipirona monoidratada','Via oral','Para dor','Para sistema nervoso','Analgésicos','Neosaldina é um medicamento com atividade analgésica (diminui a dor) e antiespasmódica (diminui contração involuntária) \nindicado para o tratamento de diversos tipos de dor de cabeça, incluindo enxaquecas ou para o tratamento de cólicas.',22.09,100),('Nuromol 12 Comprimidos','Cólica','Ibuproveno','Via oral','Para cólica','Para cólica','Analgésicos','Indicado para o alívio temporário da dor leve a moderada associada à enxaqueca, dor de cabeça, dor nas costas, \ncólica menstrual, dor dentária, dor reumática ou muscular, dor relacionada à artrite não grave, sintomas de gripes e resfriados, \ndor de garganta e febre.',26.47,100),('Paracetamol 750mg 20 comprimidos genérico','Dor muscular','Paracetamol','Via oral','Para dor','Para os musculos','Analgésicos','Paracetamol é indicado para alívio temporário de dores associadas a gripes e resfriados comuns, dor de cabeça, \ndor de dente, dor nas costas, dores associadas a artrites, cólicas menstruais e para redução da febre.',16.82,100),('Resfenol Hertz 20 Cápsulas','Congestão nasal','Cloridrato de fenilefrina','Via oral','Para gripe','Para sistema respiratório','Antigripais','Resfenol é contraindicado em pacientes com conhecida hipersensibilidade aos componentes da fórmula. Não deve ser administrado \na pacientes com hipertensão, doença cardíaca, diabete, glaucoma, hipertrofia da próstata, doença renal crônica, insuficiência hepática grave, \ndisfunção tireoidiana, gravidez e lactação sem controle médico. Resfenol induz sonolência não devendo ser utilizado por condutores de veículos, \noperadores de máquinas ou aqueles de cuja atenção dependa a segurança de outras pessoas. Não use outro produto que contenha paracetamol. \nAtenção diabéticos: solução oral: contém açúcar, cápsulas e gotas: não contém açúcar.',17.41,100),('Sal de Fruta ENO Tradicional Antiácido para Azia e Má Digestão com 2 sachês de 5g cada','Dor de estômago','Ácido cítrico','Via oral','Para azia','Para estômago','Antiácidos','Eno Sal de Fruta Tradicional é um antiácido indicado ázia, má digestão e outros transtornos estomacais, \ntais como excesso de acidez do estômago e indigestão ácida. Os componentes do Sal de Frutas Eno Tradicional, quando dissolvidos em água, reagem entre \nsi, produzindo um sal de efeito antiácido, capaz de iniciar a redução da acidez do estômago em 6 segundos.',3.55,100);
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-26 18:24:58
