package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osc.core.SalesRecorder;
import com.osc.message.Message;
import com.osc.product.Product;
import com.osc.sale.Register;

public class SalesRecorderTest {

	String stock = "apple,50,31,10";
	String stockFile = "D:\\JPM\\message-processing-app-master\\src\\resources\\sales.csv";
	String notificationFile = "D:\\JPM\\message-processing-app-master\\src\\resources\\allnotifications.json";
	private SalesRecorder salesRecorder;
	private Product product = new Product("Apple", Long.valueOf(50),Long.valueOf(31),Double.valueOf(10));
	private Register register;
	private FileReader fileReader;
	private File file;
	private TypeReference typeReference;
	private ObjectMapper mapper;
	
	@Test
	public void initializeTest() throws FileNotFoundException {
		fileReader=new FileReader(stockFile);
		salesRecorder = new SalesRecorder();
		salesRecorder.parseStockEntry(stock);
		register = new Register();
		register.addProduct(product);
		assertEquals(false,register.addProduct(product));
	}

	@Test
	public void parseTest() throws JsonParseException, JsonMappingException, IOException {
		file =new File(notificationFile);
		typeReference = new TypeReference<List<Message>>(){};
		mapper = new ObjectMapper();
		mapper.readValue(file, typeReference);
		
	}
	
	@Test
	public void process() throws JsonParseException, JsonMappingException, IOException {
		file =new File(notificationFile);
		typeReference = new TypeReference<List<Message>>(){};
		mapper = new ObjectMapper();
		mapper.readValue(file, typeReference);
		
	}
}
