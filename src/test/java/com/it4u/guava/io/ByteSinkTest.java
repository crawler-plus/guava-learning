package com.it4u.guava.io;

import com.google.common.hash.Hashing;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ByteSinkTest {

    private final String path = "ByteSinkTest.dat";

    @Test
    public void testByteSink() throws IOException {
        File file = new File(path);
        file.deleteOnExit();
        ByteSink byteSink = Files.asByteSink(file);
        byte[] bytes = {0x01, 0x02};
        byteSink.write(bytes);
        byte[] expected = Files.toByteArray(file);
        assertThat(expected, is(bytes));
    }

    @Test
    public void testFromSourceToSink() throws IOException {
        String source = "th.jpg";
        String target = "th2.jpg";
        File sourceFile = new File(source);
        File targetFile = new File(target);
        targetFile.deleteOnExit();
        ByteSource byteSource = Files.asByteSource(sourceFile);
        byteSource.copyTo(Files.asByteSink(targetFile));
        assertThat(targetFile.exists(), equalTo(true));
        assertThat(
                Files.asByteSource(sourceFile).hash(Hashing.sha256()).toString(),
                equalTo(Files.asByteSource(targetFile).hash(Hashing.sha256()).toString())
        );


    }
}
