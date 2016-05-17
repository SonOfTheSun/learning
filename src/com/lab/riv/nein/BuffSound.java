package com.lab.riv.nein;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BuffSound {

	private String path = "src\\com\\lab\\riv\\nein\\placebo_-_I_know.aiff"; 
	
	public BuffSound() {
	}

	private void play() {
		SourceDataLine sourceDataLine = null;
		AudioInputStream ais = null;
		byte buffer[] = new byte[2048];
		try {
			File soundFile = new File(path);
			ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat audioFormat = ais.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			if(!AudioSystem.isLineSupported(info)){
				System.err.println("Audio file not supported");
				System.exit(0);
			}
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();
			int num = 0;
			while((num = ais.read(buffer)) != -1){
				sourceDataLine.write(buffer, 0, num);
			}
			sourceDataLine.drain();
			ais.close();
		}catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sourceDataLine.stop();
		sourceDataLine.close();
	}
	
	public static void main(String[] args) {
		BuffSound sound = new BuffSound();
		Thread player = new Thread(new Runnable() {
			public void run() {
				sound.play();
			}
		});
		player.start();
		System.out.println("Проигрывается файл, чтобы остановить введите  1");
		Scanner sc = new Scanner(System.in);
		String fname = sc.nextLine();
		System.out.println(fname);
		if (fname.equals("1")){
			player.stop();
		}
		
	}
}
