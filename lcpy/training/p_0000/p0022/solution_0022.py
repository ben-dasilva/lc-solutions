from typing import List

par = ['(', ')']

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def gen_par(ppos, result_, n_):
            if n_ == 0:
                return

            a = ppos
            b = (ppos + 1) % 2

            if n_ == 1:
                result_.append(f'{par[a]}{par[b]}')
                return

            result_.append(f'-{par[a]}')
            gen_par(a, result_, n_ - 1)
            result_.append(f'{par[b]}-')

            result_.append(f'={par[a]}')
            gen_par(b, result_, n_ - 1)
            result_.append(f'{par[b]}=')



        result = []

        gen_par(0, result, n)

        print(f'n: {n} => {result}')


        return result

s = Solution()
s.generateParenthesis(3)