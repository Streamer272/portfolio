FROM oven/bun:latest as build

WORKDIR /app

COPY bun.lock* package.json ./
RUN bun install --frozen-lockfile

COPY . .
RUN bun run build

FROM oven/bun:latest as runner

WORKDIR /app
COPY --from=build /app/dist ./

EXPOSE 3000
CMD ["bun", "x", "serve", "--single"]
