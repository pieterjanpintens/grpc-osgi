package com.id.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.id.application.internal.SystemExit;

public class ConstantTest {

	@Rule
	public final ExpectedException fException = ExpectedException.none();

	private static Path fTmp;

	@BeforeClass
	public static void setup() throws IOException {
		fTmp = Files.createTempDirectory("test_constant_test");
	}

	@AfterClass
	public static void tearDown() throws IOException {
		delete(fTmp);
	}

	@Test
	public void getApplicationHomeNoSystenProperty() {
		fException.expect(RuntimeException.class);
		SystemExit exit = Mockito.mock(SystemExit.class);
		when(exit.printErrorAndDie(anyInt(), anyString(), any()))
				.thenThrow(new RuntimeException("The system would have exited because the path is missing"));
		Constants.getApplicationHome(exit);
	}

	@Test
	public void getApplicationHomeInvalidSystenProperty() {
		fException.expect(RuntimeException.class);
		System.setProperty("application.home", "/bull/shit/path");
		SystemExit exit = Mockito.mock(SystemExit.class);
		when(exit.printErrorAndDie(anyInt(), anyString(), any()))
				.thenThrow(new RuntimeException("The system would have exited because the path sucks"));
		Constants.getApplicationHome(exit);
	}

	@Test
	public void getApplicationHome() {
		System.setProperty("application.home", fTmp.toString());
		SystemExit exit = Mockito.mock(SystemExit.class);
		when(exit.printErrorAndDie(anyInt(), anyString(), any()))
				.thenThrow(new RuntimeException("This method should never be called in the happy case, seeing this exception is a test failure"));
		Constants.getApplicationHome(exit);
	}

	private static void delete(Path directory) throws IOException {
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
