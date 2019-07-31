from typing import List


class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        board = [
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "uvwxy",
            "z"
        ]
        pos = {}

        for r, cline in enumerate(board):
            for c, ch in enumerate(cline):
                pos[ch] = r, c

        curr_r, curr_c = 0, 0

        move = ""
        for tc in target:
            r, c = pos[tc]

            hdir = 'R' if c > curr_c else 'L'
            vdir = 'D' if r > curr_r else 'U'

            if (tc == 'z'):
                for _ in range(abs(c - curr_c)): move += hdir
                for _ in range(abs(r - curr_r)): move += vdir
            else:
                for _ in range(abs(r - curr_r)): move += vdir
                for _ in range(abs(c - curr_c)): move += hdir

            move += f'!'
            curr_r, curr_c = r, c

        return move
