/*
 * Copyright 2025 Yoel Yang. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaoyang.dutf;

import com.yaoyang.dutf.scsu.Compress;
import com.yaoyang.dutf.scsu.EndOfInputException;
import com.yaoyang.dutf.scsu.IllegalInputException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class DUTFTest {

    @Test
    public void testWikipediaData() throws IllegalInputException, EndOfInputException {
        String data = "The Badge Man is a figure said to be present within a photograph taken by Mary Moorman of the assassination of John F. Kennedy on November 22, 1963, captured a fraction of a second after a bullet struck Kennedy's head. Such a person is not present in any other photographs of the assassination and was not seen by any witnesses. Much of the detail is obscured, some believe by a muzzle flash. The moniker derives from a bright spot on what is deemed the figure's chest, said to resemble a gleaming badge. The photograph was analyzed by the House Select Committee on Assassinations, but no evidence of hidden figures was found. However, in 1983, Gary Mack—the curator of the Sixth Floor Museum—obtained a higher quality copy of the photograph. Upon enhancement, Mack noted what he believed to be the Badge Man in the shadowed background. Conspiracy theorists have suggested that this figure is a sniper or a man in police uniform, and believe it to be a second assassin, firing at Kennedy from the grassy knoll. (Full article...)";
        String data1 = "省是波兰的一级行政区。自1999年1月1日起，波兰原有的49个省获整并为16个省，而该16个省的下级行政区为此前曾被裁设的县。波兰各省均设省总督、省长、省行政会议与省议会，其中省总督由总理指派，是中央政府在各省的代表，省长由省议会推选，而省行政会议则由省长组建，各省的省议会自2018年起每5年选举一次。省行政会议与省议会分别是波兰各省的行政机关与立法机关。波兰首都华沙所在的马佐夫舍省同时是波兰面积最大与人口最多的省份，面积达35,558.8平方公里，人口达5,512,794人。奥波莱省则同时是波兰面积最小与人口最少的省份，面积仅9,411.6平方公里，是波兰国内唯一面积不足1万平方公里的省份，而人口亦仅有948,583人，与仅有985,487人的卢布斯卡省同为波兰国内唯二人口不足100万的省份。";
        String data2 = "유전학(遺傳學)은 생물의 유전과 유전자 다양성 등을 연구하는 생물학의 한 분야이다. 인간은 선사시대부터 생물의 특징이 부모로부터 자식에게 유전되는 것을 이용한 품종개량을 해왔다. 그러나 최초로 과학적인 방법으로 유전을 연구한 것은 그레고르 멘델부터이다.\n" +
                "현대 유전학의 핵심 개념은 유전자이다. 유전자는 전체 게놈 서열 가운데 DNA의 일정 구간을 이루는 염기서열의 배열이다. DNA는 뉴클레오티드들이 이중 나선의 형태로 결합되어 있는 것으로 DNA 복제를 통하여 유전형질을 다음 세대로 전달한다. 또한 세포에서 DNA의 역할은 단백질을 형성하여 생물이 생장하고 활동할 수 있도록 하는 것이다. DNA에서 전사된 전령 RNA의 코돈은 각각 하나의 아미노산과 대응하고, 아미노산에 의해 단백질이 형성된다.\n" +
                "개괄하면, 현대의 유전학은 생물의 발생과 생장, 그리고 진화에서 차지하는 유전자의 역할을 밝히고 DNA의 재조합 실험을 통해 유전체와 생물 정보를 탐구하는 폭넓은 영역의 과학이다. 또한 유전학의 지식은 여러 학문에 파급되어 의학, 농업 등에서 유전학은 필수적인 기반 지식이 되었다.";
        String data3 = "ディートリヒ・ブクステフーデは、17世紀北ドイツおよびバルト海沿岸地域を代表する作曲家・オルガニストである。声楽作品においては、バロック期ドイツの教会カンタータの形成に貢献する一方、オルガン音楽においては、ヤン・ピーテルスゾーン・スウェーリンクに端を発する北ドイツ・オルガン楽派の最大の巨匠であり、その即興的・主情的な作風はスティルス・ファンタスティクス（幻想様式）の典型とされている。\n" +
                "ブクステフーデの家系は、北ドイツ・エルベ河畔の都市ブクステフーデに由来する。13世紀から14世紀には、ハンブルク、リューベック等のバルト海沿岸の諸都市に一族の名が現れるようになる。";
        String str = data + data1 + data2 + data3;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        System.out.println("English DUTF bytes length: " + DUTF2.encode(data).length);
        System.out.println("English UTF8 bytes length: " + data.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("Chinese DUTF bytes length: " + DUTF2.encode(data1).length);
        System.out.println("Chinese UTF8 bytes length: " + data1.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("Korean DUTF bytes length: " + DUTF2.encode(data2).length);
        System.out.println("Korean UTF8 bytes length: " + data2.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("Japanese DUTF bytes length: " + DUTF2.encode(data3).length);
        System.out.println("Japanese UTF8 bytes length: " + data3.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("Mixed languages DUTF bytes length: " + DUTF2.encode(sb.toString()).length);
        System.out.println("Mixed languages UTF8 bytes length: " + sb.toString().getBytes(StandardCharsets.UTF_8).length);
        System.out.println(sb);
    }

    @Test
    public void testUDHRTxt() throws IOException, IllegalInputException, EndOfInputException {
        StringBuilder sb = new StringBuilder();
        sb.append("File name\tUTF8 size\tDUTF size\tDUTF compression\tSCSU size\tSCSU compression\n");
        File dir = new File("src/test/java/com/yaoyang/dutf/udhr_txt");
        File[] files = dir.listFiles();
        Arrays.sort(files);
        for (File file : files) {
            sb.append(file.getName() + "\t");
            String content = new String(Files.readAllBytes(file.toPath()));
            byte[] utf8Bytes = content.getBytes(StandardCharsets.UTF_8);
            sb.append(utf8Bytes.length + "\t");
            byte[] dutfBytes = DUTF2.encode(content);
            sb.append(dutfBytes.length + "\t");
            sb.append(calculateCompressionRatio(utf8Bytes.length, dutfBytes.length) + "\t");
            byte[] scsuBytes = new Compress().compress(content);
            sb.append(scsuBytes.length + "\t");
            sb.append(calculateCompressionRatio(utf8Bytes.length, scsuBytes.length));
            sb.append("\n");
        }
        Path path = Paths.get("src/test/java/com/yaoyang/dutf", "udhr-compression-result.scv");
        Files.write(path, sb.toString().getBytes());
    }

    private String calculateCompressionRatio(double originalSize, double compressedSize) {
        return String.format("%.2f", (originalSize - compressedSize) / originalSize * 100) + "%";
    }
}
