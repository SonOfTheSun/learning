package com.lab.riv.nein;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound {

	Sound(String s) {
		play(s);
	}

	public void play(String file) {
		Clip line = null;
		try { // Создаем объект, представляющий файл
			File f = new File(file);
			// Получаем информацию о способе записи файла
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(f);
			// Получаем информацию о способе записи звука
			AudioFormat af = aff.getFormat();
			// Собираем всю информацию вместе, добавляя сведения о классе Class
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			// Проверяем, можно ли проигрывать такой формат
			if (!AudioSystem.isLineSupported(info)) {
				System.err.println("Линия не поддерживается");
				System.exit(0);
			}

			// Получаем линию связи с файлом
			line = (Clip) AudioSystem.getLine(info);
			// Создаем поток байтов из файла
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			// Открываем линию
			line.open(ais);
		} catch (Exception e) {
			System.err.println(e);
		}
		// Начинаем проигрывание
		line.start();
		// Здесь надо сделать задержку до окончания проигрывания
		// или остановить его следующим методом:
		System.out.println("Проигрывается файл: " + file + ", остановить - 1");
		// Для остановки проигрывания необходимо с консоли ввести цифру 1
		Scanner sc = new Scanner(System.in);
		String fname = sc.nextLine();
		if (fname == "1")
			line.stop();
		// По окончании проигрывания закрываем линию
		line.close();
	}

	public static void main(String[] args) {
		if (args.length != 1)
			System.out.println("Вы не ввели в качестве параметра имя файла");
		new Sound(args[0]);
	}
}
