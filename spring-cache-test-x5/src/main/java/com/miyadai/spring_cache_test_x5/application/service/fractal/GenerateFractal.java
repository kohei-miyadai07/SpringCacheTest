package com.miyadai.spring_cache_test_x5.application.service.fractal;

import java.awt.image.BufferedImage;

import com.miyadai.spring_cache_test_x5.domain.model.fractal.Size;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateFractal {

	public BufferedImage generateFractal(Size size) {
		int width = size.getWidth();
		int height = size.getHeight();

		BufferedImage image =
				new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		double zx, zy, cX, cY, tmp;
        int maxIter = 100000;
        double zoom = 1;

        for (int y = 0; y < height; y++) {
        	for(int x = 0; x < width; x++) {
        		zx = zy = 0;
                cX = (x - width / 2) / zoom / width * 4;
                cY = (y - height / 2) / zoom / height * 4;
                int iter = maxIter;

                while(zx * zx + zy * zy < 4 && iter > 0) {
                	tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }

                image.setRGB(x, y, iter | (iter << 8));
        	}
        }

        log.info("フラクタル画像生成: Size: {}", size.toString());
		return image;
	}

}
