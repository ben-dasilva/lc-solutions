from typing import List


class Solution:
    @staticmethod
    def dump(v):
        print(', '.join([f'{k}: {v}' for k, v in v.items() if k != 'self']))

    def movesToMakeZigzag(self, nums: List[int]) -> int:
        # 2 cases (start up->down) or (start down->up)
        start_up_down = 0
        start_down_up = 0

        if len(nums) <= 1:
            return 0

        up_down = [*nums]
        down_up = [*nums]

        for i in range(len(nums)-1):
            if i % 2 == 0:
                # start_up_down -> expect UP move
                if up_down[i] >= up_down[i+1]:
                    diff = up_down[i] - up_down[i + 1] + 1
                    up_down[i] -= diff
                    start_up_down += diff

                # start_down_up -> expect DOWN move
                if down_up[i] <= down_up[i+1]:
                    diff = down_up[i+1] - down_up[i] + 1
                    down_up[i+1] -= diff
                    start_down_up += diff
            else:
                # start_up_down -> expect DOWN move
                if up_down[i] <= up_down[i+1]:
                    diff = up_down[i+1] - up_down[i] + 1
                    up_down[i+1] -= diff
                    start_up_down += diff

                # start_down_up -> expect UP move
                if down_up[i] >= down_up[i+1]:
                    diff = down_up[i] - down_up[i+1] + 1
                    down_up[i] -= diff
                    start_down_up += diff

        return min(start_down_up, start_up_down)