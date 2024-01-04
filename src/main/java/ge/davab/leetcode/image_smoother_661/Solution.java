package ge.davab.leetcode.image_smoother_661;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] edgedImg = getEdgedImg(img);
        int[][] smoothImg = new int[img.length][img[0].length];

        for (int row = 1; row < edgedImg.length - 1; ++row) {
            for (int col = 1; col < edgedImg[row].length - 1; ++col) {
                smoothImg[row - 1][col - 1] = getSmoothForElement(row, col, edgedImg);
            }
        }

        return smoothImg;
    }

    public int getSmoothForElement(int elRow, int elCol, int[][] edgedImg) {
        int nonEmptySum = 0, nonEmptyCount = 0;

        for (int row = elRow - 1; row <= elRow + 1; ++row) {
            for (int col = elCol - 1; col <= elCol + 1; ++col) {
                if (edgedImg[row][col] != -1) {
                    nonEmptySum += edgedImg[row][col];
                    ++nonEmptyCount;
                }
            }
        }

        return nonEmptySum / nonEmptyCount;
    }

    private int[][] getEdgedImg(int[][] img) {
        int[][] edgedImg = new int[img.length + 2][img[0].length + 2];

        for (int row = 0; row < edgedImg.length; ++row) {
            for (int col = 0; col < edgedImg[row].length; ++col) {
                edgedImg[row][col] = -1;
            }
        }

        for (int row = 0; row < img.length; ++row) {
            for (int col = 0; col < img[row].length; ++col) {
                edgedImg[row + 1][col + 1] = img[row][col];
            }
        }

        return edgedImg;
    }
}
