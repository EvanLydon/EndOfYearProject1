package testcases;

import static org.junit.Assert.*;
import gmit.Map;

import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class GeolocationTest {
	private Map loc;

	/*
	 * Create Geolocation as a singleton factory:
	 * 
	 * GeolocationFactory gf = GeolocationFactory.getInstance(); Geolocation loc
	 * = gf.getGeolocation();
	 */

	@Before
	public void setUp() {
		loc = new Map();
	}

	@After
	public void tearDown() {
		loc = null;
	}

	
	// Next 2 methods are close by the border of Wales and England

	@Test
	public void testWalesEnglandBVA() {
		String result = loc.getCountry("52.41530", "-3.198183");
		assertTrue(result.equals("Wales"));
	}

	@Test
	public void testEnglandWalesBVA() {
		String result = loc.getCountry("52.41530", "-3.189944");
		assertTrue(result.equals("England"));
	}

	// Next 2 methods are close by the border of Belgium and France
	@Test
	public void testBelgiumFranceWestBVA() {
		String result = loc.getCountry("50.510152", "3.447647");
		assertTrue(result.equals("Belgium"));
	}

	@Test
	public void testFranceBelgiumWestBVA() {
		String result = loc.getCountry("50.506658", "3.449364");
		assertTrue(result.equals("France"));
	}

	// Next 2 methods are close by the border of Andorra and Spain
	@Test
	public void testAndorraSpainBVA() {
		String result = loc.getCountry("42.436582", "1.491751");
		assertTrue(result.equals("Andorra"));
	}

	@Test
	public void testSpainAndorraBVA() {
		String result = loc.getCountry("42.431895", "1.492008");
		assertTrue(result.equals("Spain"));
	}

	// Next 2 methods are close by the border of Ireland and Northern Ireland
	@Test
	public void testIrelandNorthernIrelandBVA() {
		String result = loc.getCountry("52.259913", "-6.854419");
		assertTrue(result.equals("Ireland"));
	}

	@Test
	public void testNorthernIrelandIrelandBVA() {
		String result = loc.getCountry("54.283970", "-6.835193");
		assertTrue(result.equals("Ireland"));
	}

	// This is Argentina
	@Test
	public void testArgentina() {
		String result = loc.getCountry("-38.384942", "-61.79713");
		// Argentina Buenos Aires Airport
		assertTrue(result.equals("Argentina"));
	}

	// Next 2 methods are close by the border of Belgium and France
	@Test
	public void testBrazilParaguayBVA() {
		String result = loc.getCountry("-23.598164", "-55.522008");
		assertTrue(result.equals("Brazil"));
	}

	@Test
	public void testParaguayBrazilBVA() {
		String result = loc.getCountry("-23.537745", "-55.59073");
		assertTrue(result.equals("Paraguay"));
	}

	// Next 2 methods are close by the border of Poland and Germany
	@Test
	public void testPolandGermanyBVA() {
		String result = loc.getCountry("52.323039", "14.618829");
		assertTrue(result.equals("Poland"));
	}

	@Test
	public void testGermanyPolandBVA() {
		String result = loc.getCountry("52.319681", "14.497979");
		assertTrue(result.equals("Germany"));
	}

	// Next 2 methods are close by the border of Romania and Bulgaria
	@Test
	public void testRomaniaBulgariaBVA() {
		String result = loc.getCountry("43.706396", "25.714448");
		// This is Paranhos Brazil
		assertTrue(result.equals("Romania"));
	}

	@Test
	public void testBulgariaRomaniaBVA() {
		String result = loc.getCountry("43.680083", "25.733674");
		assertTrue(result.equals("Bulgaria"));
	}

	// Next 2 methods are close by the border of Libya and Sudan
	@Test
	public void testLibyaSudanBVA() {
		// -23.537745 -55.59073 is Paraguay
		String result = loc.getCountry("20.036637", "24.927895");
		assertTrue(result.equals("Libya"));
	}

	@Test
	public void testSudanLibyaBVA() {
		String result = loc.getCountry("19.983731", "24.640877");
		assertTrue(result.equals("Sudan"));
	}

	// Next method is in Sydney, Australia
	@Test
	public void testAustraliaBVA() {
		String result = loc.getCountry("-33.891593", "151.206704");
		assertTrue(result.equals("Australia"));
	}

	// Next 2 methods are close by the border of Afghanistan and Pakistan
	@Test
	public void testAfghanistanPakistanBVA() {
		String result = loc.getCountry("31.012749", "66.517886");
		assertTrue(result.equals("Afghanistan"));
	}

	@Test
	public void testPakistanAfghanistanBVA() {
		String result = loc.getCountry("30.909118", "66.512393");
		assertTrue(result.equals("Pakistan"));
	}

	// Next 2 methods are close by the border of Ìndia and Bangladesh
	@Test
	public void testIndiaBangladeshBVA() {
		String result = loc.getCountry("22.611286", "88.916262");
		assertTrue(result.equals("India"));
	}

	@Test
	public void testBangladeshIndiaBVA() {
		String result = loc.getCountry("22.608750", "88.987673");
		assertTrue(result.equals("Bangladesh"));
	}

	// Next 2 methods are close by the border of Thailand and Cambodia
	@Test
	public void testThailandCambodiaBVA() {
		String result = loc.getCountry("14.560790", "104.891756");
		assertTrue(result.equals("Thailand"));
	}

	@Test
	public void testCambodiaThailandBVA() {
		String result = loc.getCountry("14.326730", "104.606111");
		assertTrue(result.equals("Cambodia"));
	}

	// Next 2 methods are close by the border of Niger and Chad
	@Test
	public void testNigerChadBVA() {
		String result = loc.getCountry("16.297536", "14.672030");
		assertTrue(result.equals("Niger"));
	}

	@Test
	public void testChadNigerBVA() {
		String result = loc.getCountry("16.592569", "15.419100");
		assertTrue(result.equals("Chad"));
	}

	// Next 2 methods are close by the border of Madagascar and Indian Ocean
	@Test
	public void testMadagascarIndianOceanBVA() {
		String result = loc.getCountry("-18.209979", "49.333896");
		assertTrue(result.equals("Madagascar"));
	}

	@Test
	public void testIndianOceanMadagascarBVA() {
		String result = loc.getCountry("-18.356023", "49.399814");
		assertTrue(result.equals("Indian Ocean"));
	}

	// Next 2 methods are close by the border of Canada and Alaska
	@Test
	public void testCanadaAlaskaBVA() {
		String result = loc.getCountry("65.671385", "-140.659901");
		assertTrue(result.equals("Canada"));
	}

	@Test
	public void testAlaskaCanadaBVA() {
		String result = loc.getCountry("65.707568", "-141.187245");
		assertTrue(result.equals("Alaska"));
	}

	// Next 2 methods are close by the border of USA and Canada
	@Test
	public void testUSACanadaOceanBVA() {
		String result = loc.getCountry("48.979903", "-106.75010");
		assertTrue(result.equals("USA"));
	}

	@Test
	public void testCanadaUSABVA() {
		String result = loc.getCountry("49.014142", "-106.647893");
		assertTrue(result.equals("Canada"));
	}

	// Next 2 methods are close by the border of USA and Mexico
	@Test
	public void testUSAMexicoBVA() {
		String result = loc.getCountry("32.557816", "-116.964588");
		assertTrue(result.equals("USA"));
	}

	@Test
	public void testMexicoUSABVA() {
		String result = loc.getCountry("32.544034", "-116.991753");
		assertTrue(result.equals("Mexico"));
	}

	// Next 2 methods are close by the border of Mexico and Guatemala
	@Test
	public void testMexicoGuatemalaBVA() {
		String result = loc.getCountry("16.111792", "-91.285400");
		assertTrue(result.equals("Mexico"));
	}

	@Test
	public void testGuatemalaMexicoBVA() {
		String result = loc.getCountry("16.064290", "-91.285400");
		assertTrue(result.equals("Guatemala"));
	}

	// Next 2 methods are close by the border of Costa Rica and Panama
	@Test
	public void testCostaRicaPanamaBVA() {
		String result = loc.getCountry("8.934403", "-82.730726");
		assertTrue(result.equals("Costa Rica"));
	}

	@Test
	public void testPanamaCostaRicaBVA() {
		String result = loc.getCountry("8.931690", "-82.692274");
		assertTrue(result.equals("Panama"));
	}
	
	// Next 2 methods are close by the border of Norway and Sweden
	@Test
	public void testNorwaySwedenBVA() {
		String result = loc.getCountry("61.337534", "12.796798");
		assertTrue(result.equals("Norway"));
	}

	@Test
	public void testSwedenNorwayBVA() {
		String result = loc.getCountry("61.295349", "12.950606");
		assertTrue(result.equals("Sweden"));
	}
	
	
	// Next 2 methods are close by the border of Sweden and Finland
	@Test
	public void testSwedenFinlandBVA() {
		String result = loc.getCountry("67.369474", "23.644044");
		assertTrue(result.equals("Sweden"));
	}

	@Test
	public void testFinlandSwedenBVA() {
		String result = loc.getCountry("67.369474", "23.819825");
		assertTrue(result.equals("Finland"));
	}
	
	// Next 2 methods are close by the border of Iraq and Iran
	@Test
	public void testIraqIranBVA() {
		String result = loc.getCountry("35.263568", "45.913330");
		assertTrue(result.equals("Iraq"));
	}

	@Test
	public void testIranIraqBVA() {
		String result = loc.getCountry("16.064290", "-91.285400");
		assertTrue(result.equals("Iran"));
	}
	
	// Next 2 methods are close by the border of New Zealand and Tasman Sea
	@Test
	public void testNewZealandTasmanSeaBVA() {
		String result = loc.getCountry("-43.210646", "170.387428");
		assertTrue(result.equals("New Zealand"));
	}

	@Test
	public void testTasmanSeaNewZealandBVA() {
		String result = loc.getCountry("-43.194629", "170.167702");
		assertTrue(result.equals("Tasman Sea"));
	}
	
	// Next 2 methods are close by the border of Indonesia and Papua New Guinea
	@Test
	public void testIndonesiaPapuaNewGuineaBVA() {
		String result = loc.getCountry("-5.726849", "140.529219");
		assertTrue(result.equals("Indonesia"));
	}

	@Test
	public void testPapuaNewGuineaIndonesiaBVA() {
		String result = loc.getCountry("-6.068354", "141.158187");
		assertTrue(result.equals("Papua New Guinea"));
	}
	
	
	// Next 2 methods are close by the border of Mongolia and China
	@Test
	public void testMongoliaChinaBVA() {
		String result = loc.getCountry("42.862508", "100.388038");
		assertTrue(result.equals("Mongolia"));
	}

	@Test
	public void testChinaMongoliaBVA() {
		String result = loc.getCountry("42.539554", "100.431983");
		assertTrue(result.equals("China"));
	}
	
		
	
}
