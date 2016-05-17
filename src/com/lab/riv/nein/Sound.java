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
		try { // ������� ������, �������������� ����
			File f = new File(file);
			// �������� ���������� � ������� ������ �����
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(f);
			// �������� ���������� � ������� ������ �����
			AudioFormat af = aff.getFormat();
			// �������� ��� ���������� ������, �������� �������� � ������ Class
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			// ���������, ����� �� ����������� ����� ������
			if (!AudioSystem.isLineSupported(info)) {
				System.err.println("����� �� ��������������");
				System.exit(0);
			}

			// �������� ����� ����� � ������
			line = (Clip) AudioSystem.getLine(info);
			// ������� ����� ������ �� �����
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			// ��������� �����
			line.open(ais);
		} catch (Exception e) {
			System.err.println(e);
		}
		// �������� ������������
		line.start();
		// ����� ���� ������� �������� �� ��������� ������������
		// ��� ���������� ��� ��������� �������:
		System.out.println("������������� ����: " + file + ", ���������� - 1");
		// ��� ��������� ������������ ���������� � ������� ������ ����� 1
		Scanner sc = new Scanner(System.in);
		String fname = sc.nextLine();
		if (fname == "1")
			line.stop();
		// �� ��������� ������������ ��������� �����
		line.close();
	}

	public static void main(String[] args) {
		if (args.length != 1)
			System.out.println("�� �� ����� � �������� ��������� ��� �����");
		new Sound(args[0]);
	}
}
