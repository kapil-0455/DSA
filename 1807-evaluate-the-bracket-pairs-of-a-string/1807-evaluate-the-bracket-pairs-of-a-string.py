class Solution:

    def evaluate(self, s: str, knowledge: list[list[str]]) -> str:

        dict = {}

        for i in range(len(knowledge)):
            key = knowledge[i][0]
            value = knowledge[i][1]
            dict[key] = value

        i = 0
        ans = ''

        while i < len(s):
            if s[i] == '(':
                i += 1
                newKey = ''

                while s[i] != ')':
                    newKey += s[i]
                    i += 1

                if newKey in dict:
                    ans += dict[newKey]
                else:
                    ans += '?'

                i += 1

            else:
                ans += s[i]
                i += 1

        return ans


