package com.scmq.player.io;

import com.scmq.player.model.LyricLine;
import com.scmq.player.util.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LyricReader {
	
	private List<LyricLine> lines = new ArrayList<>();
	
	private static final Pattern PATTERN = Pattern.compile("\\[(\\d{1,2}:\\d{1,2}.\\d{1,2})\\]");

	public LyricReader() {
	}

	
	public List<LyricLine> read(File file) {
		return read(file, StringUtil.GBK);
	}

	
	public List<LyricLine> read(File file, Charset charset) {
		try {
			FileInputStream stream = new FileInputStream(file);
			return read(new BufferedReader(new InputStreamReader(stream, charset)));
		} catch (FileNotFoundException e) {
			return lines;
		}
	}

	
	public List<LyricLine> read(BufferedReader reader) {
		ArrayList<String> list = new ArrayList<>();
		try {
			for (String line; (line = reader.readLine()) != null;) {
				handle(line, list);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(reader);
		}
		lines.sort(null);
		return lines;
	}

	
	public List<LyricLine> read(String text) {
		String[] lyrics = text.split("\r\n|\n");				ArrayList<String> list = new ArrayList<>(3);
		for (String lyric : lyrics) {
			handle(lyric, list);
		}
		return lines;
	}

	private void handle(String line, List<String> list) {
				Matcher matcher = PATTERN.matcher(line);
				int end = -1;
		for (; matcher.find();) {
						list.add(matcher.group(1));						end = matcher.end();
		}
				if (end != -1) {
						String content = line.substring(end);			for (String time : list) {
								lines.add(new LyricLine(time, content));
			}
		}
		list.clear();
	}
}