package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * JAVA�汾���Զ������й���Ķ�����(����) ���ɵĸ�ʽ��: 200908010001 ǰ�漸λΪ��ǰ������,������λΪϵͳ���������͵ı�� ԭ��:
 * 1.��ȡ��ǰ���ڸ�ʽ��ֵ; 2.��ȡ�ļ�,�ϴα�ŵ�ֵ+1��Ϊ��ǰ�˴α�ŵ�ֵ (�µ�һ������´�1��ʼ���)
 */

public class SerialCode
{

	public static void main(String[] args) throws InterruptedException 
	{
		SerialNumber serial = new FileEveryDaySerialNumber(4,"EverycaySerialNumber.dat");
		System.out.println(serial.getSerialNumber());
	}
}


abstract class EveryDaySerialNumber extends SerialNumber {

	protected final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy");
	protected DecimalFormat df = null;

	public EveryDaySerialNumber(int width) {
		if (width < 1) {
			throw new IllegalArgumentException(
					"Parameter length must be great than 1!");
		}
		char[] chs = new char[width];
		for (int i = 0; i < width; i++) {
			chs[i] = '0';
		}
		df = new DecimalFormat(new String(chs));
	}

	protected String process() {
		Date date = new Date();
		int n = getOrUpdateNumber(date, 1);
		return format(date) + format(n);
	}

	protected String format(Date date) {
		return sdf.format(date);
	}

	protected String format(int num) {
		return df.format(num);
	}

	/**
	 * ������кţ�ͬʱ���³־û��洢�е�����
	 * 
	 * @param current
	 *            ��ǰ������
	 * @param start
	 *            ��ʼ�������
	 * @return ������µ����к�
	 */
	protected abstract int getOrUpdateNumber(Date current, int start);
}



class FileUtil {

	public static void rewrite(File file, String data) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static List<String> readList(File file) {
		BufferedReader br = null;
		List<String> data = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(file));
			for (String str = null; (str = br.readLine()) != null;) {
				data.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}

